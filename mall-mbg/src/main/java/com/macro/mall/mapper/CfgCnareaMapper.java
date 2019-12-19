package com.macro.mall.mapper;

import com.macro.mall.model.CfgCnarea;
import com.macro.mall.model.CfgCnareaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CfgCnareaMapper {
    long countByExample(CfgCnareaExample example);

    int deleteByExample(CfgCnareaExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CfgCnarea record);

    int insertSelective(CfgCnarea record);

    List<CfgCnarea> selectByExample(CfgCnareaExample example);

    CfgCnarea selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CfgCnarea record, @Param("example") CfgCnareaExample example);

    int updateByExample(@Param("record") CfgCnarea record, @Param("example") CfgCnareaExample example);

    int updateByPrimaryKeySelective(CfgCnarea record);

    int updateByPrimaryKey(CfgCnarea record);
}