package com.macro.mall.portal.domain;

import com.macro.mall.model.PmsProductAttribute;
import com.macro.mall.model.PmsProductAttributeValue;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 查询单个产品进行修改时返回的结果
 * Created by macro on 2018/4/26.
 */
public class PmsProductAttributeItem extends PmsProductAttribute{

    @Getter
    @Setter
    private List<PmsProductAttributeValue> valueList;

}
