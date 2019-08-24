package com.macro.mall.mapper;

import com.macro.mall.model.CfgTypeSource;
import com.macro.mall.model.CfgTypeSourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CfgTypeSourceMapper {
    long countByExample(CfgTypeSourceExample example);

    int deleteByExample(CfgTypeSourceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CfgTypeSource record);

    int insertSelective(CfgTypeSource record);

    List<CfgTypeSource> selectByExample(CfgTypeSourceExample example);

    CfgTypeSource selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CfgTypeSource record, @Param("example") CfgTypeSourceExample example);

    int updateByExample(@Param("record") CfgTypeSource record, @Param("example") CfgTypeSourceExample example);

    int updateByPrimaryKeySelective(CfgTypeSource record);

    int updateByPrimaryKey(CfgTypeSource record);
}