package com.macro.mall.dao;

import java.util.List;

import com.macro.mall.dto.PmsProductAttributeItem;
import com.macro.mall.dto.PmsProductResult;
import org.apache.ibatis.annotations.Param;


/**
 * 商品自定义Dao
 * Created by macro on 2018/4/26.
 */
public interface PmsProductDao {
    /**
     * 获取商品编辑信息
     */
    PmsProductResult getUpdateInfo(@Param("id") Long id);

    /**
     * 获取商品可选属性列表
     */
    List<PmsProductAttributeItem> getAttributeList(@Param("productid") Long productid);
}
