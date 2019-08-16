package com.macro.mall.portal.service;
import com.macro.mall.portal.dao.PmsProductResult;

/**
 * 商品管理Service
 * Created by macro on 2018/4/26.
 */
public interface PmsProductService {
   /**
     * 根据商品编号获取更新信息
     */
    PmsProductResult productInfo(Long id);
}