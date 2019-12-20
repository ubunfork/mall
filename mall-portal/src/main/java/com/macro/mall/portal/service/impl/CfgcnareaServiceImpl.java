package com.macro.mall.portal.service.impl;

import java.util.List;

import com.macro.mall.mapper.CfgCnareaMapper;
import com.macro.mall.model.CfgCnarea;
import com.macro.mall.model.CfgCnareaExample;
import com.macro.mall.portal.service.CfgcnareaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CfgcnareaServiceImpl implements CfgcnareaService{
    @Autowired
    private CfgCnareaMapper cfgCnareaMapper;

    @Override
    /**
     * 根据父编码获取子列表
     * @param parentCode
     * @return
     */
    public List<CfgCnarea> listByparentCode (Long parentCode){
       

        CfgCnareaExample example = new CfgCnareaExample();
        CfgCnareaExample.Criteria criteria = example.createCriteria();
        criteria.andParentCodeEqualTo(parentCode);
        List<CfgCnarea> list = cfgCnareaMapper.selectByExample(example);
        return  list;
    }
}