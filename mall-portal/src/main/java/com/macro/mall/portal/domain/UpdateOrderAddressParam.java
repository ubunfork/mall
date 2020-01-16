package com.macro.mall.portal.domain;

import io.swagger.annotations.ApiModelProperty;

public class UpdateOrderAddressParam {

    @ApiModelProperty("订单id")
    private Long orderId;

    @ApiModelProperty("地址id")
    private Long addressId;

    /**
     * @param addressId the addressId to set
     */
    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }
    /**
     * @return the addressId
     */
    public Long getAddressId() {
        return addressId;
    }
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
    
}