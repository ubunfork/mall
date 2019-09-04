package com.macro.mall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;


public interface CfgVerlogDao{
    
    List<String> selectverlogplatform();

    List<String> selectverlogverstion(@Param("platform") String platform);
}
