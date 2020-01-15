package com.macro.mall.portal.domain;

import com.macro.mall.model.OmsOrder;
import com.macro.mall.model.OmsOrderItem;
import com.macro.mall.model.UmsMemberReceiveAddress;

import java.util.List;

/**
 * 包含订单商品信息的订单详情
 * Created by macro on 2018/9/4.
 */
public class OmsOrderDetail extends OmsOrder {

    private List<OmsOrderItem> orderItemList;
   
    // 优惠券列表
    private List<SmsCouponHistoryDetail> couponList;

    public List<OmsOrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OmsOrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    /**
     * @param couponList the couponList to set
     */
    public void setCouponList(List<SmsCouponHistoryDetail> couponList) {
        this.couponList = couponList;
    }
    /**
     * @return the couponList
     */
    public List<SmsCouponHistoryDetail> getCouponList() {
        return couponList;
    }
}
