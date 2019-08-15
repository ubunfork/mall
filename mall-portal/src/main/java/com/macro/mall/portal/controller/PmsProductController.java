package com.macro.mall.portal.controller;

import com.macro.mall.portal.dao.PmsProductResult;
import com.macro.mall.common.api.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.macro.mall.portal.service.PmsProductService;
/**
 * 商品管理Controller
 * Created by macro on 2018/4/26.
 */
@Controller
@Api(tags = "PmsProductController", description = "商品管理")
@RequestMapping("/product")
public class PmsProductController {
   
    @Autowired
    private PmsProductService pmsProductService;

   @ApiOperation("根据商品id获取商品编辑信息")
   @RequestMapping(value = "/productInfo/{id}", method = RequestMethod.GET)
   @ResponseBody
   public CommonResult<PmsProductResult> productInfo(@PathVariable Long id) {
       PmsProductResult productResult = pmsProductService.productInfo(id);
       return CommonResult.success(productResult);
   }
}