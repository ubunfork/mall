package com.macro.mall.portal.controller;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.model.SelShop;
import com.macro.mall.portal.domain.SelCreateParam;
import com.macro.mall.portal.service.SelShopService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@Api(tags = "SelShopController", description = "店铺管理")
@RequestMapping("/seller")
public class SelShopController {
    @Autowired
    SelShopService selShopService;

    // 查询自提点信息
    @ApiOperation("店铺申请")
    @RequestMapping(value = "/creat", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody SelCreateParam shop) {
        try {
            return selShopService.create(shop);
        } catch (Exception e) {
            return CommonResult.failed(e.getMessage());
        }
      
    }
}