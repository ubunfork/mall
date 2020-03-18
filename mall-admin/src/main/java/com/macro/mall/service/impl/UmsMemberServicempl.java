package com.macro.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.service.UmsMemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.macro.mall.dao.UmsMemberInfoDao;
import com.macro.mall.dto.UmsMemberInfoResult;
import com.macro.mall.mapper.UmsAdminLoginLogMapper;
import com.macro.mall.mapper.UmsMemberLoginLogMapper;
import com.macro.mall.mapper.UmsMemberMapper;
import com.macro.mall.model.UmsAdminLoginLog;
import com.macro.mall.model.UmsMember;
import com.macro.mall.model.UmsMemberExample;
import com.macro.mall.model.UmsMemberLoginLog;
import com.macro.mall.model.UmsMemberLoginLogExample;

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

    @Autowired
    private UmsMemberInfoDao memberInfoDao;

    @Autowired
    UmsMemberLoginLogMapper memberLoginLogMapper;

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

    /**
    * 根据用户id获取用户详细信息
    */
    @Override
    public UmsMemberInfoResult userinfo(Long id){
        return memberInfoDao.memberInfo(id);
   }
     /**
     * 登陆日志
     */
    @Override
    public List<UmsMemberLoginLog> loginLog(Long id, Integer pageSize, Integer pageNum){

        PageHelper.startPage(pageNum, pageSize);
        UmsMemberLoginLogExample example = new UmsMemberLoginLogExample();
        UmsMemberLoginLogExample.Criteria criteria = example.createCriteria();
        criteria.andMemberIdEqualTo(id);
        example.setOrderByClause("create_time desc");
        return memberLoginLogMapper.selectByExample(example);
    }
    
}