package com.macro.mall.controller;

import java.util.List;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.model.CfgVerlog;
import com.macro.mall.service.CfgVerstionService;

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

/**
 * app配置管理Controller
 * Created by macro on 2018/6/1.
 */
@Controller
@Api(tags = "CfgVerlog", description = "app版本管理")
@RequestMapping("/CfgVerlog")
public class CfgVerlogController {
    @Autowired
    private CfgVerstionService cfgVerstionService;

    @ApiOperation("获取所有版本配置信息")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<CfgVerlog>> listAll() {
        List<CfgVerlog> cfgTypeList = cfgVerstionService.list();
        return CommonResult.success(cfgTypeList);
    }


    @ApiOperation(value = "添加配置分类")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    // @PreAuthorize("hasAuthority('cfg:type:create')")
    public CommonResult create(@Validated @RequestBody CfgVerlog cfgType, BindingResult result) {
        CommonResult commonResult;
        int count = cfgVerstionService.create(cfgType);
        if (count == 1) {
            commonResult = CommonResult.success(count);
        } else {
            commonResult = CommonResult.failed();
        }
        return commonResult;
    }
}