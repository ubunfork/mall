package com.macro.mall.portal.domain;

import io.swagger.annotations.ApiModelProperty;

/**
 * 生成订单时传入的参数
 * Created by macro on 2018/8/30.
 */
public class PayinfoParam {

    @ApiModelProperty(value = "订单id")
    private Long orderId;

    @ApiModelProperty(value = "支付方式")
    private Long payType;

    /**
     * @param orderId the orderId to set
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    /**
     * @return the orderId
     */
    public Long getOrderId() {
        return orderId;
    }
    /**
     * @param payType the payType to set
     */
    public void setPayType(Long payType) {
        this.payType = payType;
    }
    /**
     * @return the payType
     */
    public Long getPayType() {
        return payType;
    }
    
}
