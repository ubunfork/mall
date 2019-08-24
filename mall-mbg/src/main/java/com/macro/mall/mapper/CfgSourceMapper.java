package com.macro.mall.mapper;

import com.macro.mall.model.CfgSource;
import com.macro.mall.model.CfgSourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CfgSourceMapper {
    long countByExample(CfgSourceExample example);

    int deleteByExample(CfgSourceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CfgSource record);

    int insertSelective(CfgSource record);

    List<CfgSource> selectByExample(CfgSourceExample example);

    CfgSource selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CfgSource record, @Param("example") CfgSourceExample example);

    int updateByExample(@Param("record") CfgSource record, @Param("example") CfgSourceExample example);

    int updateByPrimaryKeySelective(CfgSource record);

    int updateByPrimaryKey(CfgSource record);
}