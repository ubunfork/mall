package com.macro.mall.portal.dao;

import java.util.List;

import com.macro.mall.portal.domain.OmsCartResult;

import org.apache.ibatis.annotations.Param;

public interface OmsCartItemDao{

    List <OmsCartResult> getOmsCartItemDto(@Param("memberid") Long memberid);
}