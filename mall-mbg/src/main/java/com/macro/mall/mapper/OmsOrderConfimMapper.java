package com.macro.mall.mapper;

import com.macro.mall.model.OmsOrderConfim;
import com.macro.mall.model.OmsOrderConfimExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OmsOrderConfimMapper {
    long countByExample(OmsOrderConfimExample example);

    int deleteByExample(OmsOrderConfimExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OmsOrderConfim record);

    int insertSelective(OmsOrderConfim record);

    List<OmsOrderConfim> selectByExample(OmsOrderConfimExample example);

    OmsOrderConfim selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OmsOrderConfim record, @Param("example") OmsOrderConfimExample example);

    int updateByExample(@Param("record") OmsOrderConfim record, @Param("example") OmsOrderConfimExample example);

    int updateByPrimaryKeySelective(OmsOrderConfim record);

    int updateByPrimaryKey(OmsOrderConfim record);
}