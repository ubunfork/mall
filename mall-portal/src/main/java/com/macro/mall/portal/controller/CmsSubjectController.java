package com.macro.mall.portal.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSONObject;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.model.CmsSubject;
import com.macro.mall.portal.service.CmsSubjectService;

import org.springframework.web.bind.annotation.*;

/**
 * app配置项管理器
 */

 @Controller
 @Api(tags = "subject", description = "专题管理")
 @RequestMapping("/subject")
 public class CmsSubjectController{

    @Autowired
    private CmsSubjectService subjectService;

    @ApiOperation("获取专题详情")
    @RequestMapping(value = "/subject/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CmsSubject> getsubjectdef(@PathVariable Long id) {
       
        CmsSubject cmsSubject = subjectService.getSubjectdef(id);
        return CommonResult.success(cmsSubject);
        
    }
 }

