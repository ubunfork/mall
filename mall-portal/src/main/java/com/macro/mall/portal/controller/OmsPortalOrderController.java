package com.macro.mall.portal.controller;

import java.util.Date;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.model.OmsOrderConfim;
import com.macro.mall.portal.domain.ConfirmOrderResult;
import com.macro.mall.portal.domain.OrderParam;
import com.macro.mall.portal.service.OmsPortalOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 订单管理Controller
 * Created by macro on 2018/8/30.
 */
@Controller
@Api(tags = "OmsPortalOrderController",description = "订单管理")
@RequestMapping("/order")
public class OmsPortalOrderController {
    

    @Autowired
    private OmsPortalOrderService portalOrderService;
    @ApiOperation("生成确认订单记录")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "type", value = "状态 0->商品详情购买 1->购物车购买", required = true, allowableValues = "0,1", paramType = "query", dataType = "Int"),		
        @ApiImplicitParam(name = "remark",value = "下单列表 ','分割 商品详情是商品id+skuid+quantity（购买数量） 购物车是购物车id", required = true, paramType = "query", dataType = "String")	
    })
    @RequestMapping(value = "/confirmOrder",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult confirmOrder(@RequestParam(value = "type") Integer type,
                               @RequestParam(value = "remark") String remark){
        CommonResult commonResult;
        OmsOrderConfim omsOrderConfim = new OmsOrderConfim();
        omsOrderConfim.setCreateTime(new Date());
        omsOrderConfim.setModifyTime(new Date());
        omsOrderConfim.setType(type);
        omsOrderConfim.setRemark(remark);
        omsOrderConfim.setStatus(0);
        int count = portalOrderService.confirmOrder(omsOrderConfim);
        if (count == 1) {
            commonResult = CommonResult.success(omsOrderConfim);
        } else {
            commonResult = CommonResult.failed();
        }
        return commonResult;
    }

    @ApiOperation("根据确认单编号返回确认订单信息")
    @RequestMapping(value = "/getConfirmOrderInfo",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<ConfirmOrderResult> getConfirmOrderInfo(@RequestParam(value = "confirmid") Long confirmid){
        ConfirmOrderResult confirmOrderResult = portalOrderService.getConfirmOrderInfo(confirmid);
        return CommonResult.success(confirmOrderResult);
    }


    @ApiOperation("根据购物车信息生成确认单信息--已废弃v1.0.1")
    @RequestMapping(value = "/generateConfirmOrder",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<ConfirmOrderResult> generateConfirmOrder(){
        ConfirmOrderResult confirmOrderResult = portalOrderService.generateConfirmOrder();
        return CommonResult.success(confirmOrderResult);
    }


    @ApiOperation("根据购物车信息生成订单")
    @RequestMapping(value = "/generateOrder",method = RequestMethod.POST)
    @ResponseBody
    public Object generateOrder(@RequestBody OrderParam orderParam){
        return portalOrderService.generateOrder(orderParam);
    }
    @ApiOperation("支付成功的回调")
    @RequestMapping(value = "/paySuccess",method = RequestMethod.POST)
    @ResponseBody
    public Object paySuccess(@RequestParam Long orderId){
        return portalOrderService.paySuccess(orderId);
    }

    @ApiOperation("自动取消超时订单")
    @RequestMapping(value = "/cancelTimeOutOrder",method = RequestMethod.POST)
    @ResponseBody
    public Object cancelTimeOutOrder(){
        return portalOrderService.cancelTimeOutOrder();
    }

    @ApiOperation("取消单个超时订单")
    @RequestMapping(value = "/cancelOrder",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult cancelOrder(Long orderId){
        portalOrderService.sendDelayMessageCancelOrder(orderId);
        return CommonResult.success(null);
    }
}
