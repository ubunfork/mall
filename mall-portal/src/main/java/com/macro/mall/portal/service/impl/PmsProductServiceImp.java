package com.macro.mall.portal.service.impl;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.macro.mall.mapper.PmsCommentMapper;
import com.macro.mall.model.PmsComment;
import com.macro.mall.model.PmsCommentExample;
import com.macro.mall.portal.dao.PmsCommentDao;
import com.macro.mall.portal.dao.PmsCommentResult;
import com.macro.mall.portal.dao.PmsProductDao;
import com.macro.mall.portal.dao.PmsProductResult;
import com.macro.mall.portal.domain.PmsProductAttributeItem;
import com.macro.mall.portal.service.PmsProductService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class PmsProductServiceImp implements PmsProductService {

    @Autowired
    private PmsProductDao productDao;

    @Autowired
    private PmsCommentMapper  commentMapper;

    @Autowired
    private PmsCommentDao  commentDao;

    @Override
    public PmsProductResult productInfo(Long id) {
        
        PmsProductResult temdata = productDao.productInfo(id);
        // 商品规格列表
        List<PmsProductAttributeItem> attlist = productDao.getAttributeList(id);
        temdata.setAttributeList(attlist);
        
        //商品评价第一条
        PageHelper.startPage(1, 1);
        List<PmsCommentResult>  commentResult =commentDao.selectCommentAndReplay(id);
        temdata.setCommentList(commentResult);
        return temdata;
    }
    /**
     * 
     */
    @Override
    public List<PmsCommentResult> commentlist(Long id, int pageNum,int pageSize){
        PageHelper.startPage(1, 5);
        return commentDao.selectCommentAndReplay(id);
    }
}