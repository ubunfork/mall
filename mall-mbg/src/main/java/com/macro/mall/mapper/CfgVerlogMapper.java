package com.macro.mall.mapper;

import com.macro.mall.model.CfgVerlog;
import com.macro.mall.model.CfgVerlogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CfgVerlogMapper {
    long countByExample(CfgVerlogExample example);

    int deleteByExample(CfgVerlogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CfgVerlog record);

    int insertSelective(CfgVerlog record);

    List<CfgVerlog> selectByExample(CfgVerlogExample example);

    CfgVerlog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CfgVerlog record, @Param("example") CfgVerlogExample example);

    int updateByExample(@Param("record") CfgVerlog record, @Param("example") CfgVerlogExample example);

    int updateByPrimaryKeySelective(CfgVerlog record);

    int updateByPrimaryKey(CfgVerlog record);
}