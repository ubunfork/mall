package com.macro.mall.service.impl;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.macro.mall.mapper.UmsIntegrationChangeHistoryMapper;
import com.macro.mall.model.UmsIntegrationChangeHistory;
import com.macro.mall.model.UmsIntegrationChangeHistoryExample;
import com.macro.mall.service.UmsIntegrationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UmsIntegrationServiceImpl implements UmsIntegrationService {


    @Autowired
    UmsIntegrationChangeHistoryMapper integrationChangeHistoryMapper;
      /**
     * 获取用户的积分历史记录
     * @param id
     * @return
     */
    @Override
    public List<UmsIntegrationChangeHistory> histroy(Long id , Integer pageSize, Integer pageNum){
        PageHelper.startPage(pageNum, pageSize);
        UmsIntegrationChangeHistoryExample example = new UmsIntegrationChangeHistoryExample();
        // UmsIntegrationChangeHistoryExample.Criteria criteria = example.createCriteria();
        example.setOrderByClause("create_time desc");
        return integrationChangeHistoryMapper.selectByExample(example);

    }
}
