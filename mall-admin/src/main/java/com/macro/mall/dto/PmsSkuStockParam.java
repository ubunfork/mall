package com.macro.mall.dto;

import java.util.List;

import com.macro.mall.model.PmsProductAttributeValue;
import com.macro.mall.model.PmsSkuStock;

import lombok.Getter;
import lombok.Setter;

public class PmsSkuStockParam extends PmsSkuStock{

    @Setter
    @Getter
    // 规格列表
    List<PmsProductAttributeValue> attributlvaluelist;

}