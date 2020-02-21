package com.macro.mall.portal.service.impl;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.mapper.CfgServiceMapper;
import com.macro.mall.mapper.UmsIntegrationChangeHistoryMapper;
import com.macro.mall.mapper.UmsMemberLevelMapper;
import com.macro.mall.mapper.UmsMemberMapper;
import com.macro.mall.model.CfgService;
import com.macro.mall.model.CfgServiceExample;
import com.macro.mall.model.UmsIntegrationChangeHistory;
import com.macro.mall.model.UmsIntegrationChangeHistoryExample;
import com.macro.mall.model.UmsMember;
import com.macro.mall.model.UmsMemberExample;
import com.macro.mall.model.UmsMemberLevel;
import com.macro.mall.model.UmsMemberLevelExample;
import com.macro.mall.portal.domain.MemberDetails;
import com.macro.mall.portal.service.RedisService;
import com.macro.mall.portal.service.UmsMemberService;
import com.macro.mall.portal.util.JwtTokenUtil;
import com.macro.mall.portal.util.ShareCodeUtil;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Map;
import java.util.HashMap;

/**
 * 会员管理Service实现类
 * Created by macro on 2018/8/3.
 */
@Service
public class UmsMemberServiceImpl implements UmsMemberService {
    @Autowired
    private UmsMemberMapper memberMapper;
    @Autowired
    private UmsMemberLevelMapper memberLevelMapper;

    @Autowired
    private UmsIntegrationChangeHistoryMapper umsIntegrationChangeHistoryMapper;

    
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RedisService redisService;
    @Autowired
    private CfgServiceMapper cfgServiceMapper;
    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;
    @Value("${redis.key.expire.authCode}")
    private Long AUTH_CODE_EXPIRE_SECONDS;

    @Override
    public UmsMember getByUsername(String username) {
        UmsMemberExample example = new UmsMemberExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<UmsMember> memberList = memberMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(memberList)) {
            return memberList.get(0);
        }
        return null;
    }

    @Override
    public UmsMember getById(Long id) {
        return memberMapper.selectByPrimaryKey(id);
    }

    @Override
    public CommonResult register(String username, String password, String telephone, String authCode,String reccode) {
        //验证验证码
        if(!verifyAuthCode(authCode,telephone)){
            return CommonResult.failed("验证码错误");
        }
        //查询是否已有该用户
        UmsMemberExample example = new UmsMemberExample();
        example.createCriteria().andUsernameEqualTo(username);
        example.or(example.createCriteria().andPhoneEqualTo(telephone));
        List<UmsMember> umsMembers = memberMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(umsMembers)) {
            return CommonResult.failed("该用户已经存在");
        }
        
        //没有该用户进行添加操作
        UmsMember umsMember = new UmsMember();
        umsMember.setUsername(username);
        umsMember.setPhone(telephone);
        umsMember.setPassword(passwordEncoder.encode(password));
        umsMember.setCreateTime(new Date());
        umsMember.setStatus(1);
        umsMember.setDepth(0);
       
        //获取默认会员等级并设置
        UmsMemberLevelExample levelExample = new UmsMemberLevelExample();
        levelExample.createCriteria().andDefaultStatusEqualTo(1);
        List<UmsMemberLevel> memberLevelList = memberLevelMapper.selectByExample(levelExample);
        if (!CollectionUtils.isEmpty(memberLevelList)) {
            umsMember.setMemberLevelId(memberLevelList.get(0).getId());
        }
        memberMapper.insertSelective(umsMember);
        umsMember.setReccode(ShareCodeUtil.toSerialCode(umsMember.getId()));
        //设置邀请用户
        if(reccode != null){
            UmsMember pumsMember = memberMapper.selectByPrimaryKey(ShareCodeUtil.codeToId(reccode));
            if(pumsMember != null){
                umsMember.setPid(pumsMember.getId());
                umsMember.setDepth(pumsMember.getDepth()+1);
                inviteIntegration(umsMember, pumsMember);
            }
        }
        memberMapper.updateByPrimaryKey(umsMember);

        umsMember.setPassword(null);
        return CommonResult.success(null,"注册成功");
    }
    @Override
    public CommonResult smslogin(String telephone, String authCode) {

        UmsMemberExample example = new UmsMemberExample();
        example.createCriteria().andPhoneEqualTo(telephone);
        List<UmsMember> memberList = memberMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(memberList)){
            return CommonResult.failed("该账号不存在");
        }
        //验证验证码
        if(!verifyAuthCode(authCode,telephone)){
            return CommonResult.failed("验证码错误");
        }
        
        UmsMember umsMember = memberList.get(0);
        umsMember.setPassword(null);
        UserDetails userDetails = userDetailsService.loadUserByUsername(umsMember.getUsername());
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenUtil.generateToken(userDetails);
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("token", token);
        dataMap.put("userinfo", umsMember);
        return CommonResult.success(dataMap, "登陆成功");
        
    }
      /**
     * 用户名/手机号码登陆
     * @param telephone 手机号码
     * @param authCode 验证码
     * @return
     */
    @Override
    public CommonResult passlogin(String username, String password){

        UmsMemberExample example = new UmsMemberExample();
        example.createCriteria().andPhoneEqualTo(username);
        example.or().andUsernameEqualTo(username);
        
        List<UmsMember> memberList = memberMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(memberList)){
            return CommonResult.failed("该账号不存在");
        }
        UmsMember umsMember = memberList.get(0);
        UserDetails userDetails = userDetailsService.loadUserByUsername(umsMember.getUsername());
        if(!passwordEncoder.matches(password,userDetails.getPassword())){
            // throw new BadCredentialsException("密码不正确");
            return CommonResult.failed("密码不正确");
        }
        umsMember.setPassword(null);
        
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenUtil.generateToken(userDetails);
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("token", token);
        dataMap.put("userinfo", umsMember);
        return CommonResult.success(dataMap, "登陆成功");

    }

    @Override
    public CommonResult generateAuthCode(String telephone) {
        String autocode = "123456";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for(int i=0;i<6;i++){
            sb.append(random.nextInt(10));
        }
        autocode = sb.toString();
        //验证码绑定手机号并存储到redis
        String keystr =  REDIS_KEY_PREFIX_AUTH_CODE+telephone;
        redisService.set(keystr,autocode);
        redisService.expire(REDIS_KEY_PREFIX_AUTH_CODE+telephone,AUTH_CODE_EXPIRE_SECONDS);

        CfgServiceExample example = new CfgServiceExample();
        example.createCriteria().andCfgKeyEqualTo("AUTHCODE");
        CfgService cfgService = cfgServiceMapper.selectByExample(example).get(0);
        
        if(cfgService.getValue().equals("0") ){
            sendAuthCode(sb.toString(),telephone);
            return CommonResult.success(null,"获取验证码成功");
        }else{
            return CommonResult.success(autocode,"获取验证码成功");
        }
        
    }

    @Override
    public CommonResult updatePassword(String telephone, String password, String authCode) {
        UmsMemberExample example = new UmsMemberExample();
        example.createCriteria().andPhoneEqualTo(telephone);
        List<UmsMember> memberList = memberMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(memberList)){
            return CommonResult.failed("该账号不存在");
        }
        //验证验证码
        if(!verifyAuthCode(authCode,telephone)){
            return CommonResult.failed("验证码错误");
        }
        UmsMember umsMember = memberList.get(0);
        umsMember.setPassword(passwordEncoder.encode(password));
        memberMapper.updateByPrimaryKeySelective(umsMember);
        return CommonResult.success(null,"密码修改成功");
    }

    @Override
    public UmsMember getCurrentMember() {
        SecurityContext ctx = SecurityContextHolder.getContext();
        Authentication auth = ctx.getAuthentication();
        Object object = auth.getPrincipal();
        MemberDetails memberDetails = (MemberDetails) object;
        return memberDetails.getUmsMember();
    }

    @Override
    public void updateIntegration(Long id, Integer integration) {
        UmsMember record=new UmsMember();
        record.setId(id);
        record.setIntegration(integration);
        memberMapper.updateByPrimaryKeySelective(record);
    }

    //对输入的验证码进行校验
    private boolean verifyAuthCode(String authCode, String telephone){
        if(StringUtils.isEmpty(authCode)){
            return false;
        }
        String realAuthCode = redisService.get(REDIS_KEY_PREFIX_AUTH_CODE + telephone);
        return authCode.equals(realAuthCode);
    }

    //通过阿里云发送验证码
    private void sendAuthCode(String authCode, String telephone){
       
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAIJySUFKQ7gSkr", "BNlEqO5ej8ymx8CknWvQPPq3mNWbZI");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", telephone);
        request.putQueryParameter("SignName", "瑞鑫科技");
        request.putQueryParameter("TemplateCode", "SMS_154589476");
        request.putQueryParameter("TemplateParam", "{\"code\":\""+authCode+"\"}");
        request.putQueryParameter("SmsUpExtendCode", authCode);
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
    // 邀请会员成功赠送积分
    private void inviteIntegration(UmsMember member, UmsMember inviteMember){
        
        CfgServiceExample example = new CfgServiceExample();
        example.createCriteria().andCfgKeyEqualTo("INVITEMEMBER");
        CfgService config = cfgServiceMapper.selectByExample(example).get(0);
        Integer setcount = Integer.valueOf(config.getValue()).intValue(); 
        if(setcount<=0){
            return;
        }
        UmsIntegrationChangeHistoryExample hexample = new UmsIntegrationChangeHistoryExample();
        hexample.setOrderByClause("create_time desc");
        hexample.createCriteria().andMemberIdEqualTo(inviteMember.getId());
        
        Long count = umsIntegrationChangeHistoryMapper.countByExample(hexample);
        Integer oldBalance = 0;
        if(count>0){
            UmsIntegrationChangeHistory history = umsIntegrationChangeHistoryMapper.selectByExample(hexample).get(0);
            oldBalance = history.getBalance();
        }
        UmsIntegrationChangeHistory integrationChangeHistory = new UmsIntegrationChangeHistory();
        
        integrationChangeHistory.setChangeCount(setcount);
        integrationChangeHistory.setOperateMan("system");
        integrationChangeHistory.setCreateTime(new Date());
        integrationChangeHistory.setMemberId(inviteMember.getId());
        integrationChangeHistory.setChangeType(0);
        String operateNote = inviteMember.getPhone()+'['+inviteMember.getId()+']'+"邀请会员"+member.getPhone()+'['+member.getId()+']'+"成功赠送积分";
        integrationChangeHistory.setOperateNote(operateNote);
        integrationChangeHistory.setSourceType(3);
        integrationChangeHistory.setBalance(oldBalance+setcount);
        umsIntegrationChangeHistoryMapper.insertSelective(integrationChangeHistory);
    }

}
