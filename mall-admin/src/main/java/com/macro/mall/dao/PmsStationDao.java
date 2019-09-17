package com.macro.mall.dao;

import java.util.List;

import com.macro.mall.model.PmsStation;

import org.apache.ibatis.annotations.Param;
public interface PmsStationDao{
    
    List<PmsStation>list(@Param("status") Integer status, @Param("address") String address);
}