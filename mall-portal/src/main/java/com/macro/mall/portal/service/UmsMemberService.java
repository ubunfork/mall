package com.macro.mall.portal.service;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.model.UmsMember;
import org.springframework.transaction.annotation.Transactional;

/**
 * 会员管理Service
 * Created by macro on 2018/8/3.
 */
public interface UmsMemberService {
    /**
     * 根据用户名获取会员
     */
    UmsMember getByUsername(String username);

    /**
     * 根据会员编号获取会员
     */
    UmsMember getById(Long id);

    /**
     * 用户注册
     */
    @Transactional
    CommonResult register(String username, String password, String telephone, String authCode, String reccode);

    /**
     * 手机号码验证码登陆
     * @param telephone 手机号码
     * @param authCode 验证码
     * @return
     */
    CommonResult smslogin(String telephone, String authCode);

    /**
     * 用户名/手机号码登陆
     * @param telephone 手机号码
     * @param authCode 验证码
     * @return
     */
    CommonResult passlogin(String username, String password);

    

    /**
     * 生成验证码
     */
    CommonResult generateAuthCode(String telephone);

    /**
     * 修改密码
     */
    @Transactional
    CommonResult updatePassword(String telephone, String password, String authCode);

    /**
     * 获取当前登录会员
     */
    UmsMember getCurrentMember();

    /**
     * 根据会员id修改会员积分
     */
    void updateIntegration(Long id,Integer integration);

    /**
     * 获取已邀请的用户列表
     * @param id
     * @return
     */
    CommonResult inviteList();
}
