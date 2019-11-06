package com.macro.mall.portal.service.impl;

import java.util.List;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.mapper.OmsLogisticsMapper;
import com.macro.mall.mapper.OmsOrderMapper;
import com.macro.mall.mapper.OmsStationMapper;
import com.macro.mall.model.OmsLogistics;
import com.macro.mall.model.OmsLogisticsExample;
import com.macro.mall.model.OmsOrder;
import com.macro.mall.model.OmsStation;

import com.macro.mall.portal.service.OmsStationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OmsStationServiceImpl implements OmsStationService {

    @Autowired
    private OmsOrderMapper omsOrderMapper;

    @Autowired
    private OmsLogisticsMapper omsLogisticsMapper;

    @Autowired
    private OmsStationMapper omsStationMapper;

    public CommonResult create(long orderid){
        //创建自提点订单
        OmsOrder omsOrder = omsOrderMapper.selectByPrimaryKey(orderid);
        if (omsOrder == null){
            return CommonResult.failed("未找到对应订单");
        }
        // 查询对应的物流订单
        OmsLogisticsExample omsLogisticsExample = new OmsLogisticsExample();
        OmsLogisticsExample.Criteria criteria = omsLogisticsExample.createCriteria();
        criteria.andOrderidEqualTo(orderid);
        List <OmsLogistics> omsLogisticss = omsLogisticsMapper.selectByExample(omsLogisticsExample);
        if (omsLogisticss.size() <= 0){
            return CommonResult.failed("未找到对应物流");
        }
        OmsLogistics omsLogistics = omsLogisticss.get(0);
        OmsStation omsStation =  new OmsStation();
        omsStation.setOrderid(omsOrder.getId());
        omsStation.setLogisticsid(omsLogistics.getId());
        int count = omsStationMapper.insert(omsStation);
        if (count<=0) {
            return CommonResult.failed("创建自提点订单失败");
        }
        return CommonResult.success(null,"创建成功");

       
    }
}