package com.macro.mall.service;

import com.macro.mall.model.CmsSubject;

import java.util.List;

/**
 * 商品专题Service
 * Created by macro on 2018/6/1.
 */
public interface CmsSubjectService {

    /**
     * 创建专题
     */
    int create(CmsSubject cmsSubject);
    /**
     * 查询所有专题
     */
    List<CmsSubject> listAll();

    /**
     * 分页查询专题
     */
    List<CmsSubject> list(String keyword, Integer pageNum, Integer pageSize);

    /**
     * 更新专题内容
     */
    int updata(CmsSubject cmsSubject);
}
