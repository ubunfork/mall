package com.macro.mall.service;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.dto.PmsSkuStockParam;
import com.macro.mall.model.PmsSkuStock;

import java.util.List;

/**
 * sku商品库存管理Service
 * Created by macro on 2018/4/27.
 */
public interface PmsSkuStockService {
    /**
     * 根据产品id和skuCode模糊搜索
     */
    List<PmsSkuStock> getList(Long pid, String keyword);

    /**
     * 批量更新商品库存信息
     */
    int update(Long pid, List<PmsSkuStock> skuStockList);

    /**
     * 给商品添加sku信息
     */
    CommonResult create(PmsSkuStockParam skuitem);


    /**
     * 根据商品id获取商品sku列表
     */
    List<PmsSkuStockParam> skuList(Long proid);
}
