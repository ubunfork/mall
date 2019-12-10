package com.macro.mall.controller;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.dto.PmsSkuStockParam;
import com.macro.mall.model.PmsSkuStock;
import com.macro.mall.service.PmsSkuStockService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * sku库存Controller
 * Created by macro on 2018/4/27.
 */
@Controller
@Api(tags = "PmsSkuStockController", description = "sku商品库存管理")
@RequestMapping("/sku")
public class PmsSkuStockController {
    @Autowired
    private PmsSkuStockService skuStockService;

    @ApiOperation("根据商品编号及编号模糊搜索sku库存")
    @RequestMapping(value = "/{pid}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PmsSkuStock>> getList(@PathVariable Long pid, @RequestParam(value = "keyword",required = false) String keyword) {
        List<PmsSkuStock> skuStockList = skuStockService.getList(pid, keyword);
        return CommonResult.success(skuStockList);
    }
    
    @ApiOperation("批量更新库存信息（废弃20191010）")
    @RequestMapping(value ="/update/{pid}",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long pid,@RequestBody List<PmsSkuStock> skuStockList){
        int count = skuStockService.update(pid,skuStockList);
        if(count>0){
            return CommonResult.success(count);
        }else{
            return CommonResult.failed();
        }
    }
    @ApiOperation("更新sku信息")
    @RequestMapping(value ="/updateskuitem",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateskuitem(@RequestBody PmsSkuStockParam skuStockParam){
        return skuStockService.updateskuitem(skuStockParam);
    }

    

    @ApiOperation("给商品添加SKU信息")
    @RequestMapping(value ="/create",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody PmsSkuStockParam skuStockParam){
        return skuStockService.create(skuStockParam);
       
    }

    @ApiOperation("根据商品id获取商品sku列表")
    @RequestMapping(value = "list/{pid}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PmsSkuStockParam>> skuList(@PathVariable Long pid) {
        List<PmsSkuStockParam> skuStockList = skuStockService.skuList(pid);
        return CommonResult.success(skuStockList);
    }


}
