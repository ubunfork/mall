package com.macro.mall.portal.dao;

import java.util.List;

import com.macro.mall.portal.dao.CfgSourceParam;
import com.macro.mall.model.CfgSource;
import com.macro.mall.model.CfgType;

import org.apache.ibatis.annotations.Param;

public interface CfgDao{

    int inserttype(CfgType cfgType);
    
    List<CfgSource> selectsource(@Param("queryParam") CfgSourceParam cfgSourceParam);
}
