package com.macro.mall.portal.service;
import java.util.List;

import com.macro.mall.portal.dao.PmsCommentResult;
import com.macro.mall.portal.dao.PmsProductResult;

/**
 * 商品管理Service
 * Created by macro on 2018/4/26.
 */
public interface PmsProductService {
   /**
     * 根据商品编号获取更新信息
     */
    PmsProductResult productInfo(Long id);

    /**
     * 
     * @param id
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<PmsCommentResult> commentlist(Long id, int pageNum,int pageSize);
}