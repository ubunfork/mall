package com.macro.mall.service;

import java.util.List;

import com.macro.mall.model.UmsIntegrationChangeHistory;

public interface UmsIntegrationService{

    /**
     * 获取用户的积分历史记录
     * @param id
     * @return
     */
    List<UmsIntegrationChangeHistory> histroy(Long id , Integer pageSize, Integer pageNum);
}