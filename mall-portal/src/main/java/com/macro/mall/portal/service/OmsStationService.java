package com.macro.mall.portal.service;

import com.macro.mall.common.api.CommonResult;

/**
 * Created by macro on 2018/8/27.
 * 自提点订单
 */
public interface OmsStationService {
   /**
    * 创建自提点叮当
    */
    CommonResult create(long orderid);
}