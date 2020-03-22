package com.macro.mall.portal.service;
import java.util.List;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.model.SelShop;
import com.macro.mall.portal.dao.PmsCommentResult;
import com.macro.mall.portal.dao.PmsProductResult;
import com.macro.mall.portal.domain.SelCreateParam;

/**
 * 商品管理Service
 * Created by macro on 2018/4/26.
 */
public interface SelShopService {
   /**
     * 店铺申请
     */
    CommonResult create(SelCreateParam param);


}