package com.macro.mall.controller;

import java.util.List;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.model.UmsIntegrationChangeHistory;
import com.macro.mall.service.UmsIntegrationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 后台用户管理
 * Created by macro on 2018/4/26.
 */
@Controller
@Api(tags = "UmsIntegrationController", description = "会员积分管理")
@RequestMapping("/integration")
public class UmsIntegrationController {

    @Autowired
    UmsIntegrationService umsIntegrationService;
    @ApiOperation(value = "查询会员的积分历史记录")
    @RequestMapping(value = "/history/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<UmsIntegrationChangeHistory>> history(@PathVariable Long id,
        @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {

         return CommonResult.success(umsIntegrationService.histroy(id, pageSize, pageNum)) ;
    }

}