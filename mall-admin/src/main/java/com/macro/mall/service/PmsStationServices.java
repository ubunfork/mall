package com.macro.mall.service;

import java.util.List;

import com.macro.mall.model.PmsStation;

public interface PmsStationServices{
    // 根据条件获取自提点记录 状态 ，地址（模糊搜索）
    List<PmsStation>list(Integer status, String address);

    // 修改自提点状态
    int update(PmsStation pmsStation);

}