package com.macro.mall.service.impl;

import com.macro.mall.dao.CfgDao;
import com.macro.mall.mapper.CfgSourceMapper;
import com.macro.mall.mapper.CfgTypeMapper;
import com.macro.mall.mapper.CfgTypeSourceMapper;
import com.macro.mall.model.CfgSource;
import com.macro.mall.model.CfgType;
import com.macro.mall.model.CfgTypeExample;
import com.macro.mall.model.CfgTypeSource;
import com.macro.mall.service.CfgService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
/**
 * app配置Service实现类
 * Created by macro on 2018/6/1.
 */
@Service
public class CfgServiceImpl implements CfgService {
    @Autowired
    private CfgTypeMapper cfgTypeMapper;
    @Autowired
    private CfgSourceMapper cfgSourceMapper;
    @Autowired
    private CfgTypeSourceMapper  cfgTypeSourceMapper;
    @Autowired
    private CfgDao cfgDao;

    @Override
    public List<CfgType> listAllType() {

        return cfgTypeMapper.selectByExample(new CfgTypeExample());
    }

    @Override
    public int createType(CfgType cfgType){
        return cfgDao.inserttype(cfgType);
    }

    @Override
    public int addsource(Long id, CfgSource cfgSource){
        //插入source
        int rcount = cfgSourceMapper.insert(cfgSource);
        if(rcount == 0){
            return rcount;
        }
        //插入关联
        CfgTypeSource cfgTypeSource = new CfgTypeSource();
        cfgTypeSource.setTypeid(id);
        cfgTypeSource.setSourceid(cfgSource.getId());
        cfgTypeSource.setModifyTime(new Date());
        return  cfgTypeSourceMapper.insert(cfgTypeSource);
    }
}
