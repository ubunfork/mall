package com.macro.mall.mapper;

import com.macro.mall.model.CfgType;
import com.macro.mall.model.CfgTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CfgTypeMapper {
    long countByExample(CfgTypeExample example);

    int deleteByExample(CfgTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CfgType record);

    int insertSelective(CfgType record);

    List<CfgType> selectByExample(CfgTypeExample example);

    CfgType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CfgType record, @Param("example") CfgTypeExample example);

    int updateByExample(@Param("record") CfgType record, @Param("example") CfgTypeExample example);

    int updateByPrimaryKeySelective(CfgType record);

    int updateByPrimaryKey(CfgType record);
}