package com.macro.mall.portal.service;

import java.util.List;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.model.OmsOrderConfim;
import com.macro.mall.portal.domain.OmsOrderDetail;
import com.macro.mall.portal.domain.OrderParam;
import com.macro.mall.portal.domain.PayinfoParam;

import org.springframework.transaction.annotation.Transactional;

/**
 * 前台订单管理Service
 * Created by macro on 2018/8/30.
 */
public interface OmsPortalOrderService {
    /**
     * 1:根据购物车ids生成确认订单记录
     * 2:根据1商品id+skuid生成确认订单记录
     */
    CommonResult confirmOrder(OmsOrderConfim omsOrderConfim);


    /**
     * 删除确认订单单信息
     */
    Integer deleteConfirmOrder();

    /**
     * 根据提交信息生成订单
     */
    @Transactional
    CommonResult generateOrder(OrderParam orderParam);


    /**
     * 支付成功后的回调
     */
    @Transactional
    CommonResult paySuccess(Long orderId);

    /**
     * 自动取消超时订单
     */
    @Transactional
    CommonResult cancelTimeOutOrder();

    /**
     * 取消单个超时订单
     */
    @Transactional
    void cancelOrder(Long orderId);

    /**
     * 发送延迟消息取消订单
     */
    void sendDelayMessageCancelOrder(Long orderId);

    /**
     * 根据状态获取用户订单列表
     */
    List<OmsOrderDetail> orderList(Integer status, Integer pageNum,Integer pageSize);

    /**
     * 根据订单id获取订单详情
     */
    OmsOrderDetail orderinfo(Long orderId);

    /**
     * 自动取消超时订单
     * orderId 订单id
     * payType 支付类型 
     */
    @Transactional
    CommonResult payInfo(PayinfoParam param);
}
