package com.macro.mall.service.impl;

import com.macro.mall.dao.CfgDao;
import com.macro.mall.dto.CfgSourceParam;
import com.macro.mall.mapper.CfgSourceMapper;
import com.macro.mall.mapper.CfgTypeMapper;
import com.macro.mall.mapper.CfgTypeSourceMapper;
import com.macro.mall.model.CfgSource;
import com.macro.mall.model.CfgType;
import com.macro.mall.model.CfgTypeExample;
import com.macro.mall.model.CfgTypeSource;
import com.macro.mall.model.CfgTypeSourceExample;
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

    @Autowired
    private CfgTypeSourceMapper CfgTypeSourceMapper;

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
    @Override
    public List<CfgSource> getsourcebytype(CfgSourceParam cfgSourceParam){
        return  cfgDao.selectsource(cfgSourceParam);
    }

    @Override
    public int deletetype(Long id){
 
        CfgTypeSourceExample example = new CfgTypeSourceExample();
        CfgTypeSourceExample.Criteria criteria = example.createCriteria();
        criteria.andTypeidEqualTo(id);
        List<CfgTypeSource> typesourctlist= CfgTypeSourceMapper.selectByExample(example);
        for (CfgTypeSource typesourct : typesourctlist) {
            cfgSourceMapper.deleteByPrimaryKey(typesourct.getSourceid());
            cfgTypeSourceMapper.deleteByPrimaryKey(typesourct.getId());
        }
        int rcount = cfgTypeMapper.deleteByPrimaryKey(id.intValue());
        return rcount;
    }

}
