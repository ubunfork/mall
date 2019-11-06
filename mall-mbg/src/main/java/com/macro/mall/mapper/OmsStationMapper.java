package com.macro.mall.mapper;

import com.macro.mall.model.OmsStation;
import com.macro.mall.model.OmsStationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OmsStationMapper {
    long countByExample(OmsStationExample example);

    int deleteByExample(OmsStationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OmsStation record);

    int insertSelective(OmsStation record);

    List<OmsStation> selectByExample(OmsStationExample example);

    OmsStation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OmsStation record, @Param("example") OmsStationExample example);

    int updateByExample(@Param("record") OmsStation record, @Param("example") OmsStationExample example);

    int updateByPrimaryKeySelective(OmsStation record);

    int updateByPrimaryKey(OmsStation record);
}