package com.macro.mall.portal.dao;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

/**
 * 查询单个产品进行修改时返回的结果
 * Created by macro on 2018/4/26.
 */
public class PmsProductResult extends PmsProductParam{

    @ApiModelProperty("评价数据")
    private List<PmsCommentResult> commentList;

    //商品所选分类的父id
    private Long cateParentId;

    public Long getCateParentId() {
        return cateParentId;
    }

    public void setCateParentId(Long cateParentId) {
        this.cateParentId = cateParentId;
    }

    /**
     * @return the commentList
     */
    public List<PmsCommentResult> getCommentList() {
        return commentList;
    }
    /**
     * @param commentList the commentList to set
     */
    public void setCommentList(List<PmsCommentResult> commentList) {
        this.commentList = commentList;
    }
}
