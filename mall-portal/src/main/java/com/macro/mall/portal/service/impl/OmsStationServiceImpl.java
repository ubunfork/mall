package com.macro.mall.portal.service.impl;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.mapper.OmsLogisticsMapper;
import com.macro.mall.mapper.OmsOrderMapper;
import com.macro.mall.mapper.OmsStationMapper;
import com.macro.mall.mapper.PmsStationMapper;
import com.macro.mall.model.OmsLogistics;
import com.macro.mall.model.OmsLogisticsExample;
import com.macro.mall.model.OmsOrder;
import com.macro.mall.model.OmsStation;
import com.macro.mall.model.OmsStationExample;
import com.macro.mall.model.PmsStation;
import com.macro.mall.model.PmsStationExample;
import com.macro.mall.model.UmsMember;
import com.macro.mall.portal.service.OmsStationService;
import com.macro.mall.portal.service.UmsMemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OmsStationServiceImpl implements OmsStationService {

    @Autowired
    private UmsMemberService memberService;

    @Autowired
    private OmsOrderMapper omsOrderMapper;

    @Autowired
    private OmsLogisticsMapper omsLogisticsMapper;

    @Autowired
    private OmsStationMapper omsStationMapper;

    @Autowired
    private PmsStationMapper pmsStationMapper;

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

    /**
     * 查询自提点用户的自提点订单
     */
    public CommonResult orderlist(int status, int pageNum,int pageSize){
        // 获取登陆用户
        UmsMember currentMember = memberService.getCurrentMember();
        // 获取登陆用户的自提点列表
        PmsStationExample example = new PmsStationExample();
        PmsStationExample.Criteria criteria = example.createCriteria();
        criteria.andMemberIdEqualTo(currentMember.getId());
        List<PmsStation> pmsStationlist = pmsStationMapper.selectByExample(example);
        PmsStation pmsStation = pmsStationlist.get(0);

        // 分页获取自提点订单
        PageHelper.startPage(pageNum, pageSize);
        OmsStationExample sexample = new OmsStationExample();
        OmsStationExample.Criteria scriteria = sexample.createCriteria();
        scriteria.andStationidEqualTo(pmsStation.getId());
        if(status>0){
            scriteria.andStatusEqualTo(status);
        }
        List<OmsStation> omsStation = omsStationMapper.selectByExample(sexample);
        return CommonResult.success(omsStation,"创建成功");
    }
}