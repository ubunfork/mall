package com.macro.mall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.macro.mall.bo.AdminUserDetails;
import com.macro.mall.dao.PmsStationDao;
import com.macro.mall.mapper.PmsStationMapper;
import com.macro.mall.model.PmsStation;
import com.macro.mall.model.UmsPermission;
import com.macro.mall.service.PmsStationServices;
import com.macro.mall.service.UmsAdminService;
@Service
public class PmsStationServicesImpl implements PmsStationServices{
    @Autowired
    private PmsStationMapper pmsStationMapper;

    @Autowired
    private PmsStationDao pmsStationDao;
    @Autowired
    private UmsAdminService umsAdminService;
   // 根据条件获取自提点记录 状态 ，地址（模糊搜索）
   public List<PmsStation>list(Integer status, String address){
        
        return pmsStationDao.list(status, address);
   }

   // 修改自提点状态
   public int update(PmsStation pmsStation){
        UmsPermission umsPermission = umsAdminService.getCurrentMember();
        return pmsStationMapper.updateByPrimaryKey(pmsStation);

   }
}