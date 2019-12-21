package com.macro.mall.dto;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

/**
 * 查询单个产品进行修改时返回的结果
 * Created by macro on 2018/4/26.
 */
public class PmsProductResult extends PmsProductParam {
    //商品所选分类的父id
    private Long cateParentId;

    @ApiModelProperty("商品参数及自定义规格属性")
    private List<PmsProductAttributeItem> attributeList;

    public Long getCateParentId() {
        return cateParentId;
    }

    public void setCateParentId(Long cateParentId) {
        this.cateParentId = cateParentId;
    }

 
    /**
     * @param attributeList the attributeList to set
     */
    public void setAttributeList(List<PmsProductAttributeItem> attributeList) {
        this.attributeList = attributeList;
    }
    /**
     * @return the attributeList
     */
    public List<PmsProductAttributeItem> getAttributeList() {
        return attributeList;
    }
}
