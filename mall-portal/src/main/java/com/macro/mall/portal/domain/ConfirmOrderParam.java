package com.macro.mall.portal.domain;

import io.swagger.annotations.ApiModelProperty;

/**
 * 生成订单时传入的参数
 * Created by macro on 2018/8/30.
 */
public class ConfirmOrderParam {

    @ApiModelProperty(value = "状态 0->商品详情购买 1->购物车购买")
    private int type;

    @ApiModelProperty(value = "下单列表 ','分割 type为0商品详情是商品id+skuid+quantity（购买数量） type为1购物车是购物车id")
    private String remark;

    /**
     * @param remark the remark to set
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
    /**
     * @return the remark
     */
    public String getRemark() {
        return remark;
    }
    /**
     * @param type the type to set
     */
    public void setType(int type) {
        this.type = type;
    }
    /**
     * @return the type
     */
    public int getType() {
        return type;
    }
}
