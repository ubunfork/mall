package com.macro.mall.portal.dao;

import java.util.List;


import org.apache.ibatis.annotations.Param;

public interface PmsCommentDao{

    
    /**
     * 获取商品评价列表
     */
    List<PmsCommentResult> selectCommentAndReplay(@Param("parductId") Long parductId);

}
