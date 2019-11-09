package com.macro.mall.portal.service;

import com.macro.mall.common.api.CommonResult;

/**
 * Created by macro on 2018/8/27.
 * 自提点订单
 */
public interface OmsStationService {
   /**
    * 创建自提点订单
    */
    CommonResult create(long orderid);

    /**
     * 查询自提点用户的自提点订单
     */
    CommonResult orderlist(int status, int pageNum,int pageSize);

}