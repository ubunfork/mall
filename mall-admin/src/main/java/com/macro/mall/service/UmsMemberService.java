package com.macro.mall.service;

import com.macro.mall.dto.UmsMemberInfoResult;
import com.macro.mall.model.UmsMember;

import java.util.List;
/**
 * 用户管理Service
 * Created by macro on 2018/4/26.
 */
public interface UmsMemberService {

    /**
     * 根据用户名或昵称分页查询用户
     */
    List<UmsMember> list(String name, Integer pageSize, Integer pageNum);

    /**
     * 根据用户id获取用户详细信息
     */
    UmsMemberInfoResult userinfo(Long id);
}