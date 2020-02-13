package com.macro.mall.portal.service;

import java.util.List;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.model.PmsProductCategory;

/**
 * Created by macro on 2018/8/27.
 * 商品分类管理
 */
public interface PmsProductCategoryService {
    /**
     * 根据父id获取下面所有分类
     */
    CommonResult<List<PmsProductCategory>> listbyParentid(long parentID);

 }