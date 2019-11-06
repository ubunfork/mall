package com.macro.mall.mapper;

import com.macro.mall.model.OmsLogistics;
import com.macro.mall.model.OmsLogisticsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OmsLogisticsMapper {
    long countByExample(OmsLogisticsExample example);

    int deleteByExample(OmsLogisticsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OmsLogistics record);

    int insertSelective(OmsLogistics record);

    List<OmsLogistics> selectByExample(OmsLogisticsExample example);

    OmsLogistics selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OmsLogistics record, @Param("example") OmsLogisticsExample example);

    int updateByExample(@Param("record") OmsLogistics record, @Param("example") OmsLogisticsExample example);

    int updateByPrimaryKeySelective(OmsLogistics record);

    int updateByPrimaryKey(OmsLogistics record);
}