package com.macro.mall.portal.service.impl;

import java.util.List;

import com.macro.mall.portal.dao.CfgDao;
import com.macro.mall.portal.dao.CfgSourceParam;
import com.macro.mall.model.CfgSource;
import com.macro.mall.portal.service.CfgService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CfgServiceImpl implements CfgService{
    @Autowired
    private CfgDao cfgDao;
    @Override
    public List<CfgSource> getsourcebytype (CfgSourceParam cfgSourceParam){
        List<CfgSource> list = cfgDao.selectsource(cfgSourceParam); 
        return  list;
    }
}