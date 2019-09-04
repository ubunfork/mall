package com.macro.mall.portal.controller;

import java.util.List;

import com.macro.mall.model.CfgSource;
import com.macro.mall.portal.dao.CfgSourceParam;
import com.macro.mall.portal.service.CfgService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSONObject;
import com.macro.mall.common.api.CommonResult;
import org.springframework.web.bind.annotation.*;

/**
 * app配置项管理器
 */

 @Controller
 @Api(tags = "Cgfcontroller", description = "app配置项管理器")
 @RequestMapping("/cfg")
 public class Cfgcontroller{

    @Autowired
    private CfgService cfgService;

    @ApiOperation("根据配置类型获取配置参数")
    @RequestMapping(value = "/getvalue", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<CfgSource>> getsourcebytype(
    @RequestParam(value = "typeid") Integer typeid,
    @RequestHeader(value="client_Agent") String clientAgent
    ) {
        CommonResult commonResult;
        String verstion ,platform;
        try {
            JSONObject object = JSONObject.parseObject(clientAgent);
            verstion = object.getString("verstion");
            platform = object.getString("platform");
        } catch (Exception e) {
            return CommonResult.failed("版本号和平台号错误");
        }
       
        CfgSourceParam  cfgSourceParam = new CfgSourceParam();
        cfgSourceParam.setPlatform(platform);
        cfgSourceParam.setTypeid(typeid);
        cfgSourceParam.setVerstion(verstion);

        List<CfgSource > cfgSource = cfgService.getsourcebytype(cfgSourceParam);
        commonResult = CommonResult.success(cfgSource);
        return commonResult;
    }
 }

