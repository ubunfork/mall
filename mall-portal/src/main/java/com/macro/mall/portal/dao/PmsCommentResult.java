package com.macro.mall.portal.dao;

import java.util.List;

import com.macro.mall.model.PmsComment;
import com.macro.mall.model.PmsCommentReplay;

import io.swagger.annotations.ApiModelProperty;

/**
 * 查询单个产品进行修改时返回的结果
 * Created by macro on 2018/4/26.
 */
public class PmsCommentResult extends PmsComment{

    @ApiModelProperty("产品评价回复表")
    private List<PmsCommentReplay> replayList;

    /**
     * @return the replayList
     */
    public List<PmsCommentReplay> getReplayList() {
        return replayList;
    }

    /**
     * @param replayList the replayList to set
     */
    public void setReplayList(List<PmsCommentReplay> replayList) {
        this.replayList = replayList;
    }

}