package com.macro.mall.mapper;

import com.macro.mall.model.CfgService;
import com.macro.mall.model.CfgServiceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CfgServiceMapper {
    long countByExample(CfgServiceExample example);

    int deleteByExample(CfgServiceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CfgService record);

    int insertSelective(CfgService record);

    List<CfgService> selectByExample(CfgServiceExample example);

    CfgService selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CfgService record, @Param("example") CfgServiceExample example);

    int updateByExample(@Param("record") CfgService record, @Param("example") CfgServiceExample example);

    int updateByPrimaryKeySelective(CfgService record);

    int updateByPrimaryKey(CfgService record);
}