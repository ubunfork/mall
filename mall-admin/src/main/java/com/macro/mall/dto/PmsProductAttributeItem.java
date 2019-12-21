package com.macro.mall.dto;

import com.macro.mall.model.PmsProductAttribute;
import com.macro.mall.model.PmsProductAttributeValue;

import java.util.List;


/**
 * 查询单个产品进行修改时返回的结果
 * Created by macro on 2018/4/26.
 */
public class PmsProductAttributeItem extends PmsProductAttribute{


    private List<PmsProductAttributeValue> valueList;
    
    public List<PmsProductAttributeValue> getValueList() {
        return valueList;
    }

    public void setValueList(List<PmsProductAttributeValue> valueList) {
        this.valueList = valueList;
    }

}
