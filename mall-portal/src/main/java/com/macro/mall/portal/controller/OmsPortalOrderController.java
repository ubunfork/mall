package com.macro.mall.portal.controller;

import java.util.Date;
import java.util.List;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.model.OmsOrderConfim;
import com.macro.mall.portal.domain.ConfirmOrderParam;
import com.macro.mall.portal.domain.ConfirmOrderResult;
import com.macro.mall.portal.domain.OmsOrderDetail;
import com.macro.mall.portal.domain.OrderParam;
import com.macro.mall.model.OmsOrder;
import com.macro.mall.portal.service.OmsPortalOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 订单管理Controller Created by macro on 2018/8/30.
 */
@Controller
@Api(tags = "OmsPortalOrderController", description = "订单管理")
@RequestMapping("/order")
public class OmsPortalOrderController {

    @Autowired
    private OmsPortalOrderService portalOrderService;

    @ApiOperation("生成订单")
    @RequestMapping(value = "/confirmOrder", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult confirmOrder(@RequestBody ConfirmOrderParam param) {
       
        OmsOrderConfim omsOrderConfim = new OmsOrderConfim();
        omsOrderConfim.setCreateTime(new Date());
        omsOrderConfim.setModifyTime(new Date());
        omsOrderConfim.setType(param.getType());
        omsOrderConfim.setRemark(param.getRemark());
        omsOrderConfim.setStatus(0);
        return portalOrderService.confirmOrder(omsOrderConfim);
    }

    @ApiOperation("根据确认单编号返回确认订单信息")
    @RequestMapping(value = "/getConfirmOrderInfo", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<ConfirmOrderResult> getConfirmOrderInfo(@RequestParam(value = "confirmid") Long confirmid) {
        ConfirmOrderResult confirmOrderResult = portalOrderService.getConfirmOrderInfo(confirmid);
        return CommonResult.success(confirmOrderResult);
    }

    @ApiOperation("根据购物车信息生成确认单信息--已废弃v1.0.1")
    @RequestMapping(value = "/generateConfirmOrder", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<ConfirmOrderResult> generateConfirmOrder() {
        ConfirmOrderResult confirmOrderResult = portalOrderService.generateConfirmOrder();
        return CommonResult.success(confirmOrderResult);
    }

    @ApiOperation("根据购物车信息生成订单--已废弃v1.0.1")
    @RequestMapping(value = "/generateOrder", method = RequestMethod.POST)
    @ResponseBody
    public Object generateOrder(@RequestBody OrderParam orderParam) {
        return portalOrderService.generateOrder(orderParam);
    }

    @ApiOperation("根据确认信息生成支付订单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "confirmId", value = "确认信息id", required = true, paramType = "query", dataType = "Long"),
            @ApiImplicitParam(name = "addressId", value = "收货地址id", required = true, paramType = "query", dataType = "Long"),
            @ApiImplicitParam(name = "couponId", value = "优惠券id", required = false, paramType = "query", dataType = "Long"),
            @ApiImplicitParam(name = "useIntegration", value = "使用的积分数", required = true, paramType = "query", dataType = "Int") })
    @RequestMapping(value = "/generatePayOrder", method = RequestMethod.POST)
    @ResponseBody
    public Object generatePayOrder(@RequestParam(value = "confirmId") Long confirmId,
            @RequestParam(value = "addressId", required = false) Long addressId,
            @RequestParam(value = "couponId") Long couponId,
            @RequestParam(value = "useIntegration") Integer useIntegration) {
        if (addressId == null || addressId == 0) {
            return CommonResult.failed("请选择收货地址");
        }
        OrderParam orderParam = new OrderParam();
        orderParam.setConfirmid(confirmId);
        orderParam.setMemberReceiveAddressId(addressId);
        orderParam.setCouponId(couponId);
        orderParam.setUseIntegration(useIntegration);
        return portalOrderService.generatePayOrder(orderParam);
    }

    @ApiOperation("支付成功的回调")
    @RequestMapping(value = "/paySuccess", method = RequestMethod.POST)
    @ResponseBody
    public Object paySuccess(@RequestParam Long orderId) {
        return portalOrderService.paySuccess(orderId);
    }

    @ApiOperation("自动取消超时订单")
    @RequestMapping(value = "/cancelTimeOutOrder", method = RequestMethod.POST)
    @ResponseBody
    public Object cancelTimeOutOrder() {
        return portalOrderService.cancelTimeOutOrder();
    }

    @ApiOperation("取消单个超时订单")
    @RequestMapping(value = "/cancelOrder", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult cancelOrder(Long orderId) {
        portalOrderService.sendDelayMessageCancelOrder(orderId);
        return CommonResult.success(null);
    }

    @ApiOperation("删除超时确认订单")
    @RequestMapping(value = "/deleteConfimorder", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult deleteConfimorder() {
        int count = portalOrderService.deleteConfirmOrder();
        return CommonResult.success(null);
    }

    /**
     * 分页获取商品购买订单列表
     */
    @ApiOperation("分页获取商品购买订单列表")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "status", value = "订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单", required = true, paramType = "query", dataType = "Int"), })
    @RequestMapping(value = "/orderlist", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<OmsOrderDetail>> orderlist(@RequestParam Integer status,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {

        List<OmsOrderDetail> commResult = portalOrderService.orderList(status, pageNum, pageSize);
        return CommonResult.success(commResult);
    }

        /**
     * 分页获取商品购买订单列表
     */
    @ApiOperation("根据订单编号获取订单详情")
    // @ApiImplicitParams({
        // @ApiImplicitParam(name = "orderId", value = "订单编号", required = true) })
    @RequestMapping(value = "/orderinfo", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<OmsOrderDetail> orderinfo(@RequestParam Long orderId) {

        OmsOrderDetail commResult = portalOrderService.orderinfo(orderId);
        return CommonResult.success(commResult);
    }

}
