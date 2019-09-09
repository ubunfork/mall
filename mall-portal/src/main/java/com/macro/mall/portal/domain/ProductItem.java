package com.macro.mall.portal.domain;

import java.math.BigDecimal;

import com.macro.mall.model.PmsProduct;
import com.macro.mall.model.PmsSkuStock;

/**
 * 可购买商品信息
 * Created by ubungit on 2019/9/9.
 */
public class ProductItem extends PmsSkuStock {

    //促销活动信息
    private String promotionMessage;

    private PmsProduct product;//sku相关商品信息

    private Integer quantity;//购买数量

    //促销活动减去的金额，针对每个商品
    private BigDecimal reduceAmount;


    /**
     * @param product the product to set
     */
    public void setProduct(PmsProduct product) {
        this.product = product;
    }

    /**
     * @return the product
     */
    public PmsProduct getProduct() {
        return product;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the quantity
     */
    public Integer getQuantity() {
        return quantity;
    }


    public void setReduceAmount(BigDecimal reduceAmount) {
        this.reduceAmount = reduceAmount;
    }
    /**
     * @return the reduceAmount
     */
    public BigDecimal getReduceAmount() {
        return reduceAmount;
    }
    /**
     * @param promotionMessage the promotionMessage to set
     */
    public void setPromotionMessage(String promotionMessage) {
        this.promotionMessage = promotionMessage;
    }
    /**
     * @return the promotionMessage
     */
    public String getPromotionMessage() {
        return promotionMessage;
    }
    
}