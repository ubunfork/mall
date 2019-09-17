package com.macro.mall.controller;

import java.util.List;

import com.macro.mall.common.api.CommonResult;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


// 修改自提点状态
/**
 * 自提点的Controller
 */
@Controller
@Api(tags = "PmsStationController", description = "自提点的管理")
@RequestMapping("/pmsStation")
public class PmsStationController {

    // 根据条件获取自提点记录 状态 ，地址（模糊搜索）
    // @ApiOperation("根据条件获取自提点记录 状态 ，地址（模糊搜索）")
    // @RequestMapping(value = "list", method = RequestMethod.GET)
    // @RequestBody
    // public CommonResult<List<String>> list(){
    //     return CommonResult.success(skuStockList);
    // }
}