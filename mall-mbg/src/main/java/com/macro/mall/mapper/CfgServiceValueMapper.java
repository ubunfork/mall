package com.macro.mall.mapper;

import com.macro.mall.model.CfgServiceValue;
import com.macro.mall.model.CfgServiceValueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CfgServiceValueMapper {
    long countByExample(CfgServiceValueExample example);

    int deleteByExample(CfgServiceValueExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CfgServiceValue record);

    int insertSelective(CfgServiceValue record);

    List<CfgServiceValue> selectByExample(CfgServiceValueExample example);

    CfgServiceValue selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CfgServiceValue record, @Param("example") CfgServiceValueExample example);

    int updateByExample(@Param("record") CfgServiceValue record, @Param("example") CfgServiceValueExample example);

    int updateByPrimaryKeySelective(CfgServiceValue record);

    int updateByPrimaryKey(CfgServiceValue record);
}