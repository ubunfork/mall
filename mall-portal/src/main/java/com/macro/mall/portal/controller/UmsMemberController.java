package com.macro.mall.portal.controller;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.portal.service.UmsMemberService;
import com.macro.mall.portal.domain.PassLoginInput;
import com.macro.mall.portal.domain.UmsRegisterInput;
import com.macro.mall.portal.domain.UmsSmsloginInput;
import com.macro.mall.portal.domain.UmsUpPasswordInput;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 会员登录注册管理Controller
 * Created by macro on 2018/8/3.
 */
@Controller
@Api(tags = "UmsMemberController", description = "会员登录注册管理")
@RequestMapping("/sso")
public class UmsMemberController {
    @Autowired
    private UmsMemberService memberService;

    @ApiOperation("注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult register(@RequestBody UmsRegisterInput umsRegisterInput) {
        return memberService.register(
            umsRegisterInput.getUsername(), 
            umsRegisterInput.getPassword() ,
            umsRegisterInput.getTelephone(),
            umsRegisterInput.getAuthCode(),
            umsRegisterInput.getReccode());
    }

    @ApiOperation(value = "验证码登录以后返回token")
    @RequestMapping(value = "/smslogin", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult smslogin(@RequestBody UmsSmsloginInput smsloginInput) {
        return memberService.smslogin(smsloginInput.getTelephone(), smsloginInput.getAuthCode());
    }

    @ApiOperation(value = "用户名/手机号密码登录以后返回token")
    @RequestMapping(value = "/passlogin", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult passlogin(@RequestBody PassLoginInput passLoginInput) {
        return memberService.passlogin(passLoginInput.getUsername(), passLoginInput.getPassword());
    }

    @ApiOperation("获取验证码")
    @RequestMapping(value = "/getAuthCode", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getAuthCode(@RequestParam String telephone) {
        return memberService.generateAuthCode(telephone);
    }

    @ApiOperation("修改密码")
    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updatePassword(@RequestBody UmsUpPasswordInput upPasswordInput) {
        return memberService.updatePassword(upPasswordInput.getTelephone(),upPasswordInput.getPassword(),upPasswordInput.getAuthCode());
    }

    @ApiOperation("获取已邀请会员列表")
    @RequestMapping(value = "/inviteList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult inviteList() {
        return memberService.inviteList();
    }
}
