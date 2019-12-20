package com.macro.mall.portal.controller;

import java.util.List;

import com.macro.mall.model.CfgCnarea;
import com.macro.mall.portal.service.CfgcnareaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.macro.mall.common.api.CommonResult;
import org.springframework.web.bind.annotation.*;

/**
 * app配置项管理器
 */

 @Controller
 @Api(tags = "CfgcnareaController", description = "地址管理")
 @RequestMapping("/cnarea")
 public class CfgcnareaController{

    @Autowired
    private CfgcnareaService cfgcnareaService;

    @ApiOperation("根据父编码获取对应地址列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<CfgCnarea>> getsourcebytype(
    @RequestParam(value = "parentCode") Long parentCode
    ) {
        List<CfgCnarea > cfgSource = cfgcnareaService.listByparentCode(parentCode);
        return CommonResult.success(cfgSource);
    }
 }

