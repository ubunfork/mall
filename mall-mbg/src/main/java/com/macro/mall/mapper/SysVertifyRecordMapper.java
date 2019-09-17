package com.macro.mall.mapper;

import com.macro.mall.model.SysVertifyRecord;
import com.macro.mall.model.SysVertifyRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysVertifyRecordMapper {
    long countByExample(SysVertifyRecordExample example);

    int deleteByExample(SysVertifyRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysVertifyRecord record);

    int insertSelective(SysVertifyRecord record);

    List<SysVertifyRecord> selectByExample(SysVertifyRecordExample example);

    SysVertifyRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysVertifyRecord record, @Param("example") SysVertifyRecordExample example);

    int updateByExample(@Param("record") SysVertifyRecord record, @Param("example") SysVertifyRecordExample example);

    int updateByPrimaryKeySelective(SysVertifyRecord record);

    int updateByPrimaryKey(SysVertifyRecord record);
}