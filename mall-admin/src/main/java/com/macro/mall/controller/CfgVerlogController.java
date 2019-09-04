package com.macro.mall.controller;

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

import java.util.Date;
import java.util.List;
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


    @ApiOperation(value = "添加版本")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    // @PreAuthorize("hasAuthority('cfg:type:create')")
    public CommonResult create(@Validated @RequestBody CfgVerlog cfgType, BindingResult result) {
        CommonResult commonResult;
        cfgType.setCreateTime(new Date());
        cfgType.setModifyTime(new Date());
        int count = cfgVerstionService.create(cfgType);
        if (count == 1) {
            commonResult = CommonResult.success(count);
        } else {
            commonResult = CommonResult.failed();
        }
        return commonResult;
    }

    @ApiOperation(value = "更新版本信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    // @PreAuthorize("hasAuthority('cfg:type:create')")
    public CommonResult update(@PathVariable Long id, @RequestBody CfgVerlog cfgVerlog,  BindingResult bindingResult) {
       
        int count = cfgVerstionService.update(cfgVerlog);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation(value = "删除版本记录")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    // @PreAuthorize("hasAuthority('cfg:type:create')")
    public CommonResult delete(@PathVariable Long id) {
      
        int count = cfgVerstionService.delete(id);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("获取所有版本信息平台列表")
    @RequestMapping(value = "/listplatform", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<String>> listplatform() {
        List<String> platformlList = cfgVerstionService.listplatform();
        return CommonResult.success(platformlList);
    }

    @ApiOperation("获取所有版本信息列表")
    @RequestMapping(value = "/listverstion", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<String>> listverstion(String platfrom) {
        List<String> platformlList = cfgVerstionService.listverstion(platfrom);
        return CommonResult.success(platformlList);
    }
}