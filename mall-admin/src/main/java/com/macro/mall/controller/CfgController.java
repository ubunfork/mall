package com.macro.mall.controller;

import java.util.List;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.model.CfgSource;
import com.macro.mall.model.CfgType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import io.swagger.annotations.Api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.macro.mall.service.CfgService;
/**
 * app配置管理Controller
 * Created by macro on 2018/6/1.
 */
@Controller
@Api(tags = "CfgController", description = "app配置管理")
@RequestMapping("/config")
public class CfgController {
    @Autowired
    private CfgService cfgService;

    @ApiOperation("获取所有配置分类")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<CfgType>> listAll() {
        List<CfgType> cfgTypeList = cfgService.listAllType();
        return CommonResult.success(cfgTypeList);
    }

    @ApiOperation(value = "添加配置分类")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    // @PreAuthorize("hasAuthority('cfg:type:create')")
    public CommonResult create(@Validated @RequestBody CfgType cfgType, BindingResult result) {
        CommonResult commonResult;
        int count = cfgService.createType(cfgType);
        if (count == 1) {
            commonResult = CommonResult.success(count);
        } else {
            commonResult = CommonResult.failed();
        }
        return commonResult;
    }



    @ApiOperation(value = "给配置分类添加分类资源")
    @RequestMapping(value = "/addsource/{id}", method = RequestMethod.POST)
    @ResponseBody
    // @PreAuthorize("hasAuthority('cfg:type:addsource')")
    public CommonResult create(@PathVariable("id") Long id, @Validated @RequestBody CfgSource cfgSource, BindingResult result) {
        CommonResult commonResult;
        int count = cfgService.addsource(id, cfgSource);
        if (count == 1) {
            commonResult = CommonResult.success(count);
        } else {
            commonResult = CommonResult.failed();
        }
        return commonResult;
    }

}