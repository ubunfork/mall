package com.macro.mall.portal.service.impl;

import com.macro.mall.mapper.CmsSubjectMapper;
import com.macro.mall.model.CmsSubject;
import com.macro.mall.portal.service.CmsSubjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CmsSubjectServiceImpl implements CmsSubjectService{

    @Autowired
    private CmsSubjectMapper cmsSubjectMapper;

    @Override
    public  CmsSubject getSubjectdef(long id){
        CmsSubject cmsSubject =  cmsSubjectMapper.selectByPrimaryKey(id);
        cmsSubject.setReadCount(cmsSubject.getReadCount()+1);
        cmsSubjectMapper.updateByPrimaryKey(cmsSubject);
        return cmsSubjectMapper.selectByPrimaryKey(id);
    }
}