package com.macro.mall.dao;

import com.macro.mall.dto.UmsMemberInfoResult;

import org.apache.ibatis.annotations.Param;

public interface UmsMemberInfoDao{
    /**
     * 获取用户详情
     */
    UmsMemberInfoResult memberInfo(@Param("id") Long id);

}