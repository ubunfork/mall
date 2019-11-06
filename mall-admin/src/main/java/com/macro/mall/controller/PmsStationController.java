package com.macro.mall.controller;

import com.macro.mall.bo.AdminUserDetails;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.mapper.PmsStationMapper;
import com.macro.mall.mapper.SysVertifyRecordMapper;
import com.macro.mall.model.PmsStation;
import com.macro.mall.model.SysVertifyRecord;
import com.macro.mall.service.PmsStationServices;
import com.macro.mall.service.UmsAdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.Date;
import java.util.List;

/**
 * 自提点的Controller
 */
@Controller
@Api(tags = "PmsStationController", description = "自提点的管理")
@RequestMapping("/pmsStation")
public class PmsStationController {
    @Autowired
    private PmsStationServices pmsStationServices;
    @Autowired
    private UmsAdminService umsAdminService;

    @Autowired
    private PmsStationMapper PmsStationMapper;

    @Autowired
    private SysVertifyRecordMapper sysVertifyRecordMapper;

    // 根据条件获取自提点记录 状态 ，地址（模糊搜索）
    @ApiOperation("根据条件获取自提点记录 状态 ，地址（模糊搜索）")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PmsStation>> list(
        @RequestParam(value = "status",required = false) Integer status,
        @RequestParam(value = "address",required = false) String address
    ){
        List<PmsStation> stationlist = pmsStationServices.list(status,address);
        return CommonResult.success(stationlist);
    }

    // 修改自提点状态
    @ApiOperation("审核自提点/修改自提点审核状态")
    @RequestMapping(value = "/update/{id}" ,method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(
        @PathVariable Long id, 
        @RequestParam Integer status,
        @RequestParam String detail
        ){
        PmsStation pmsStation = PmsStationMapper.selectByPrimaryKey(id);
        if(pmsStation == null){
            return CommonResult.failed();
        }
        pmsStation.setStatus(status);
        int count = pmsStationServices.update(pmsStation);
        if (count > 0) {
            //添加操作记录
            AdminUserDetails umsPermission = umsAdminService.getCurrentMember();
            SysVertifyRecord sysVertifyRecord = new SysVertifyRecord();
            sysVertifyRecord.setCreateTime(new Date());
            sysVertifyRecord.setDefId(pmsStation.getId());
            sysVertifyRecord.setStatus(pmsStation.getStatus());
            sysVertifyRecord.setDetail(detail);
            sysVertifyRecord.setType(1);
            sysVertifyRecord.setVerId(umsPermission.getUserid());
            sysVertifyRecordMapper.insert(sysVertifyRecord);
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
    //获取自提点审核记录

    @ApiOperation("根据条件获取自提点记录 状态 ，地址（模糊搜索）")
    @RequestMapping(value = "/history", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<SysVertifyRecord>> history(
        @RequestParam(value = "stationId",required = false) Long stationId
    ){
        List<SysVertifyRecord> stationlist = pmsStationServices.history(stationId);
        return CommonResult.success(stationlist);
    }

}