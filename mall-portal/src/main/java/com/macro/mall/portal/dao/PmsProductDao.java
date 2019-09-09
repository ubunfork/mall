package com.macro.mall.portal.dao;

import com.macro.mall.portal.dao.PmsProductResult;
import com.macro.mall.portal.domain.ProductItem;

import org.apache.ibatis.annotations.Param;


/**
 * 商品自定义Dao
 * Created by macro on 2018/4/26.
 */
public interface PmsProductDao {
    /**
     * 获取商品编辑信息
     */
    PmsProductResult productInfo(@Param("id") Long id);

    /**
     * 获取可购买商品信息
     */
    ProductItem getproductitem(@Param("productid") Long productid,@Param("skuid") Long skuid);
}