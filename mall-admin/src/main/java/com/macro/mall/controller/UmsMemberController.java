package com.macro.mall.controller;

import com.macro.mall.common.api.CommonPage;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.dto.UmsMemberInfoResult;
import com.macro.mall.service.UmsMemberService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.macro.mall.model.UmsMember;


import java.util.List;


/**
 * 会员登录注册管理Controller
 * Created by macro on 2018/8/3.
 */
@Controller
@Api(tags = "UmsMemberController", description = "客户端会员管理")
@RequestMapping("/member")
public class UmsMemberController {
    @Autowired
    private UmsMemberService memberService;

    @ApiOperation("获取用户列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<UmsMember>>  list(@RequestParam(value = "name", required = false) String name,
    @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
            List<UmsMember> memberList = memberService.list(name, pageSize, pageNum);
            return CommonResult.success(CommonPage.restPage(memberList));
        
    }


    @ApiOperation("获取会员信息")
    @RequestMapping(value = "/userinfo/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<UmsMemberInfoResult> userinfo(@PathVariable Long id) {
       
        return CommonResult.success(memberService.userinfo(id));
    }


}