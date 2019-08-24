package com.macro.mall.dao;

import com.macro.mall.model.CfgSource;
import com.macro.mall.model.CfgType;

import org.apache.ibatis.annotations.Param;

public interface CfgDao{
    int inserttype(CfgType cfgType);
}
