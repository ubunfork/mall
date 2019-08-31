package com.macro.mall.service.impl;

import com.macro.mall.service.CfgVerstionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.macro.mall.mapper.CfgVerlogMapper;
import com.macro.mall.model.CfgVerlog;
import com.macro.mall.model.CfgVerlogExample;

import java.util.Arrays;
import java.util.List;

/**
 * app配置Service实现类
 * Created by macro on 2018/6/1.
 */
@Service
public class CfgVerstionServiceImpl implements CfgVerstionService {
    @Autowired
    private CfgVerlogMapper cfgVerlogMapper;
    @Override
    public List<CfgVerlog> list() {

        return cfgVerlogMapper.selectByExample(new CfgVerlogExample());
    }

    @Override
    public int create(CfgVerlog cfgVerlog){
        return cfgVerlogMapper.insert(cfgVerlog);
    }

    @Override
    public int update(CfgVerlog cfgVerlog) {
        return cfgVerlogMapper.updateByPrimaryKey(cfgVerlog);
    }

    @Override
    public int delete(Long id) {
        return cfgVerlogMapper.deleteByPrimaryKey(id);
    }
    
    @Override 
    public List<Integer> listplatform(){
        List<Integer> list = Arrays.asList(1,2,4);
        return  list;
    }
 
}