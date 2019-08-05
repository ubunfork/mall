package com.macro.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.service.UmsMemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.macro.mall.mapper.UmsMemberMapper;
import com.macro.mall.model.UmsMember;
import com.macro.mall.model.UmsMemberExample;
import org.springframework.util.StringUtils;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
import java.util.List;
/**
 * UmsAdminService实现类
 * Created by macro on 2018/4/26.
 */
@Service
public class UmsMemberServicempl implements UmsMemberService {
    // private static final Logger LOGGER = LoggerFactory.getLogger(UmsMemberServicempl.class);
    @Autowired
    private UmsMemberMapper memberMapper;

    @Override
    public List<UmsMember> list(String name, Integer pageSize, Integer pageNum) {

        PageHelper.startPage(pageNum, pageSize);
        UmsMemberExample example = new UmsMemberExample();
        UmsMemberExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(name)) {
            criteria.andUsernameLike("%" + name + "%");
            example.or(example.createCriteria().andNicknameLike("%" + name + "%"));
            example.or(example.createCriteria().andPhoneLike("%" + name + "%"));
        }
        return memberMapper.selectByExample(example);
    }
    
}