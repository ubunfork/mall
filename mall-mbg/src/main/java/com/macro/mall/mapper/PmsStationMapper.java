package com.macro.mall.mapper;

import com.macro.mall.model.PmsStation;
import com.macro.mall.model.PmsStationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PmsStationMapper {
    long countByExample(PmsStationExample example);

    int deleteByExample(PmsStationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PmsStation record);

    int insertSelective(PmsStation record);

    List<PmsStation> selectByExample(PmsStationExample example);

    PmsStation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PmsStation record, @Param("example") PmsStationExample example);

    int updateByExample(@Param("record") PmsStation record, @Param("example") PmsStationExample example);

    int updateByPrimaryKeySelective(PmsStation record);

    int updateByPrimaryKey(PmsStation record);
}