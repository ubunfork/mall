package com.macro.mall.controller;

import java.util.List;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.model.CfgService;
import com.macro.mall.model.CfgServiceValue;
import com.macro.mall.model.CfgSource;
import com.macro.mall.model.CfgType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import io.swagger.annotations.Api;

import com.macro.mall.dto.CfgServiceResult;
import com.macro.mall.dto.CfgSourceParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.macro.mall.service.CfgServices;
/**
 * app配置管理Controller
 * Created by macro on 2018/6/1.
 */
@Controller
@Api(tags = "CfgController", description = "app配置管理")
@RequestMapping("/config")
public class CfgController {
    @Autowired
    private CfgServices cfgServices;

    @ApiOperation("获取所有配置分类")
    @RequestMapping(value = "/listtype", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<CfgType>> listtype() {
        List<CfgType> cfgTypeList = cfgServices.listAllType();
        return CommonResult.success(cfgTypeList);
    }

    @ApiOperation(value = "添加配置分类")
    @RequestMapping(value = "/createtype", method = RequestMethod.POST)
    @ResponseBody
    // @PreAuthorize("hasAuthority('cfg:type:create')")
    public CommonResult createtype(@Validated @RequestBody CfgType cfgType, BindingResult result) {
        CommonResult commonResult;
        int count = cfgServices.createType(cfgType);
        if (count == 1) {
            commonResult = CommonResult.success(count);
        } else {
            commonResult = CommonResult.failed();
        }
        return commonResult;
    }

    @ApiOperation(value = "修改配置分类")
    @RequestMapping(value = "/updatetype/{id}", method = RequestMethod.POST)
    @ResponseBody
    // @PreAuthorize("hasAuthority('cfg:type:create')")
    public CommonResult updatetype(@PathVariable("id") Integer id, @Validated @RequestBody CfgType cfgType, BindingResult result) {
        CommonResult commonResult;
       
        int count = cfgServices.updateType(id, cfgType);
        if (count == 1) {
            commonResult = CommonResult.success(count);
        } else {
            commonResult = CommonResult.failed();
        }
        return commonResult;
    }


    @ApiOperation("删除配置分类")
    @RequestMapping(value = "/deletetype/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult deletetype(@PathVariable("id") Long id) {
        int count = cfgServices.deletetype(id);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation(value = "给配置分类添加分类资源")
    @RequestMapping(value = "/createsource/{typeid}", method = RequestMethod.POST)
    @ResponseBody
    // @PreAuthorize("hasAuthority('cfg:type:addsource')")
    public CommonResult createsource(@PathVariable("typeid") Long typeid, @Validated @RequestBody CfgSource cfgSource, BindingResult result) {
        CommonResult commonResult;
        int count = cfgServices.addsource(typeid, cfgSource);
        if (count == 1) {
            commonResult = CommonResult.success(count);
        } else {
            commonResult = CommonResult.failed();
        }
        return commonResult;
    }

    @ApiOperation(value = "更新配置资源")
    @RequestMapping(value = "/updatesource/{id}", method = RequestMethod.POST)
    @ResponseBody
    // @PreAuthorize("hasAuthority('cfg:type:addsource')")
    public CommonResult updatesource(@PathVariable("id") Long id, @Validated @RequestBody CfgSource cfgSource, BindingResult result) {
        CommonResult commonResult;
        int count = cfgServices.updatesource(id,cfgSource);
        if (count == 1) {
            commonResult = CommonResult.success(count);
        } else {
            commonResult = CommonResult.failed();
        }
        return commonResult;
    }

    @ApiOperation(value = "删除配置资源")
    @RequestMapping(value = "/deletesource/{id}", method = RequestMethod.POST)
    @ResponseBody
    // @PreAuthorize("hasAuthority('cfg:type:addsource')")
    public CommonResult deletesource(@PathVariable("id") Long id) {
        CommonResult commonResult;
        int count = cfgServices.deletesource(id);
        if (count == 1) {
            commonResult = CommonResult.success(count);
        } else {
            commonResult = CommonResult.failed();
        }
        return commonResult;
    }


    @ApiOperation("根据配置分类获取配置资源")
    @RequestMapping(value = "/getsourcebytype", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<CfgSource>> getsourcebytype(CfgSourceParam cfgSourceParam , BindingResult result) {
        CommonResult commonResult;
        List<CfgSource > cfgSources = cfgServices.getsourcebytype(cfgSourceParam);
        commonResult = CommonResult.success(cfgSources);
        return commonResult;
    }

    @ApiOperation("根据配置类型获取下属配置列表 0 获取所有配置类型")
    @RequestMapping(value = "/getserviec", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<CfgServiceResult>> getserviec(Integer parentid) {
        if(parentid == null){
            parentid = 0;
        }
        CommonResult commonResult;
        List<CfgServiceResult > cfgSource = cfgServices.listservice(parentid);
        commonResult = CommonResult.success(cfgSource);
        return commonResult;
    }

    @ApiOperation(value = "更新服务器配置")
    @RequestMapping(value = "/updateServiceSetting/{id}", method = RequestMethod.POST)
    @ResponseBody
    // @PreAuthorize("hasAuthority('cfg:type:addsource')")
    public CommonResult updateServiceSetting(@PathVariable("id") Integer id, @Validated @RequestBody CfgService cfgService, BindingResult result) {
        CommonResult commonResult;
        int count = cfgServices.updateservice(id, cfgService);
        if (count == 1) {
            commonResult = CommonResult.success(count);
        } else {
            commonResult = CommonResult.failed();
        }
        return commonResult;
    }


}