package com.macro.mall.portal.service.impl;

import java.util.List;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.mapper.PmsProductCategoryMapper;
import com.macro.mall.model.PmsProductCategory;
import com.macro.mall.model.PmsProductCategoryExample;
import com.macro.mall.portal.service.PmsProductCategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PmsProductCategoryServiceImpl implements PmsProductCategoryService {

    @Autowired
    private PmsProductCategoryMapper pmsProductCategorydMapper;
      /**
     * 根据父id获取下面所有分类
     */
    public CommonResult<List<PmsProductCategory>> listbyParentid(long parentID){
        PmsProductCategoryExample example = new PmsProductCategoryExample();
        PmsProductCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentID);
        List<PmsProductCategory> list = pmsProductCategorydMapper.selectByExample(example);
        return CommonResult.success(list);
    }
}