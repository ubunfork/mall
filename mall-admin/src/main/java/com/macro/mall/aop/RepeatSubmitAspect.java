package com.macro.mall.aop;

import com.macro.mall.aop.NoRepeatSubmit;
import java.util.UUID;
import com.macro.mall.common.api.CommonResult;
import javax.servlet.http.HttpServletRequest;
import com.macro.mall.util.RedisLockUtil;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class RepeatSubmitAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(RepeatSubmitAspect.class);

    @Autowired
    private RedisLockUtil redisLock;

    @Pointcut("@annotation(noRepeatSubmit)")
    public void pointCut(NoRepeatSubmit noRepeatSubmit) {
    }

    @Around("pointCut(noRepeatSubmit)")
    public Object around(ProceedingJoinPoint pjp, NoRepeatSubmit noRepeatSubmit) throws Throwable {
        int lockSeconds = noRepeatSubmit.lockTime();
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Assert.notNull(request, "request can not null");

        // 此处可以用token或者JSessionId
        String token = request.getHeader("Authorization");
        String path = request.getServletPath();
        String key = getKey(token, path);
        String clientId = getClientId();
        try {
            LOGGER.info("tryLock key = [{}], clientId = [{}]", key, clientId);
            boolean isSuccess = redisLock.tryLock(key, clientId, lockSeconds);
            
            if (isSuccess) {
                LOGGER.info("tryLock success, key = [{}], clientId = [{}]", key, clientId);
                // 获取锁成功
                Object result;
    
                try {
                    // 执行进程
                    result = pjp.proceed();
                } finally {
                    // 解锁
                    redisLock.releaseLock(key, clientId);
                    LOGGER.info("releaseLock success, key = [{}], clientId = [{}]", key, clientId);
                
                }
    
                return result;
    
            } else {
                // 获取锁失败，认为是重复提交的请求
                LOGGER.info("tryLock fail, key = [{}]", key);
                return CommonResult.failed();
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            return CommonResult.failed();
        }
    }

    private String getKey(String token, String path) {
        return token + path;
    }

    private String getClientId() {
        return UUID.randomUUID().toString();
    }

}
