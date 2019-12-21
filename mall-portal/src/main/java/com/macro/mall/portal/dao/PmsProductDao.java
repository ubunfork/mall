package com.macro.mall.portal.dao;

import java.util.List;

import com.macro.mall.portal.dao.PmsProductResult;
import com.macro.mall.portal.domain.PmsProductAttributeItem;
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

    /**
     * 获取商品可选属性列表
     */
    List<PmsProductAttributeItem> getAttributeList(@Param("productid") Long productid);

    /**
     * 获取商品SKU信息
     */
    List<PmsProductSkuResult>getskuStickList(@Param("productid") Long productid);
    
}