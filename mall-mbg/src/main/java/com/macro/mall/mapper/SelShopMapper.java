package com.macro.mall.mapper;

import com.macro.mall.model.SelShop;
import com.macro.mall.model.SelShopExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SelShopMapper {
    long countByExample(SelShopExample example);

    int deleteByExample(SelShopExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SelShop record);

    int insertSelective(SelShop record);

    List<SelShop> selectByExample(SelShopExample example);

    SelShop selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SelShop record, @Param("example") SelShopExample example);

    int updateByExample(@Param("record") SelShop record, @Param("example") SelShopExample example);

    int updateByPrimaryKeySelective(SelShop record);

    int updateByPrimaryKey(SelShop record);
}