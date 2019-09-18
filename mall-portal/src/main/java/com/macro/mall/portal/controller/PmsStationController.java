package com.macro.mall.portal.controller;

import java.util.List;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.mapper.PmsStationMapper;
import com.macro.mall.model.PmsStation;
import com.macro.mall.model.PmsStationExample;
import com.macro.mall.portal.service.UmsMemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 自提点Controller Created by macro on 2018/4/26.
 */
@Controller
@Api(tags = "PmsStationController", description = "商品管理")
@RequestMapping("station")
public class PmsStationController {
    @Autowired
    PmsStationMapper pmsStationMapper;
    @Autowired
    private UmsMemberService memberService;

    // 申请成为自提点
    @ApiOperation("申请/修改自提点")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ApiImplicitParams({ @ApiImplicitParam(name = "name", value = "自提点名称", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "phoneNumber", value = "电话", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "province", value = "省", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "city", value = "市", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "region", value = "区", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "detailAddress", value = "具体地址", paramType = "query", dataType = "String"), })
    @ResponseBody
    public CommonResult create(@RequestParam(value = "name") String name,
            @RequestParam(value = "phoneNumber") String phoneNumber, @RequestParam(value = "province") String province,
            @RequestParam(value = "city") String city, @RequestParam(value = "region") String region,
            @RequestParam(value = "detailAddress") String detailAddress) {
        // 判断是否已申请
      
        PmsStation pmsStation = new PmsStation();
        pmsStation.setMemberId(memberService.getCurrentMember().getId());
        pmsStation.setStatus(0);
        pmsStation.setName(name);
        pmsStation.setPhoneNumber(phoneNumber);
        pmsStation.setProvince(province);
        pmsStation.setCity(city);
        pmsStation.setRegion(region);
        pmsStation.setDetailAddress(detailAddress);

        PmsStationExample example = new PmsStationExample();
        example.createCriteria().andMemberIdEqualTo(memberService.getCurrentMember().getId());
        List<PmsStation>list = pmsStationMapper.selectByExample(example);
        int count = 0;
        if(!list.isEmpty()){
            PmsStation hpmsStation = list.get(0);
            pmsStation.setId(hpmsStation.getId());
            count= pmsStationMapper.updateByPrimaryKey(pmsStation);
        }else{
            count= pmsStationMapper.insert(pmsStation); 
        }
        
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }
    // 查询自提点信息
    @ApiOperation("根据商品id获取商品编辑信息")
    @RequestMapping(value = "/getStation", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<PmsStation> getStation() {
        PmsStationExample example = new PmsStationExample();
        example.createCriteria().andMemberIdEqualTo(memberService.getCurrentMember().getId());
        List<PmsStation>list = pmsStationMapper.selectByExample(example);
        if(list.isEmpty()){
            return CommonResult.success(null);
        }else{
            PmsStation pmsStation = list.get(0);
            return CommonResult.success(pmsStation);
        }
    }
}