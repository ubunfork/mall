package com.macro.mall.portal.domain;

import lombok.Getter;
import lombok.Setter;

import com.macro.mall.model.OmsCartItem;
import com.macro.mall.model.PmsProduct;
import com.macro.mall.model.PmsSkuStock;

/**
 * 订单详情信息
 * Created by macro on 2018/10/11.
 */
public class OmsCartResult extends  OmsCartItem{
    @Getter
    @Setter
    private PmsProduct pmsProduct;
    @Getter
    @Setter
    private PmsSkuStock pmsSkuStock;
}