package com.macro.mall.portal.dao;

import java.util.List;

import com.macro.mall.model.PmsProductAttributeValue;
import com.macro.mall.model.PmsSkuStock;




public class PmsProductSkuResult extends PmsSkuStock{

    //sku的属性值

    List<PmsProductAttributeValue> attributes;

    /**
     * @param attributes the attributes to set
     */
    public void setAttributes(List<PmsProductAttributeValue> attributes) {
        this.attributes = attributes;
    }

    /**
     * @return the attributes
     */
    public List<PmsProductAttributeValue> getAttributes() {
        return attributes;
    }
}