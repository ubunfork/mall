package com.macro.mall.dto;

import java.util.List;

import com.macro.mall.model.CfgService;
import com.macro.mall.model.CfgServiceValue;

import io.swagger.annotations.ApiModelProperty;



/**
 * 查询单个产品进行修改时返回的结果
 * Created by macro on 2018/4/26.
 */
public class CfgServiceResult extends CfgService {

    @ApiModelProperty("配置可选项")
    private List<CfgServiceValue> vlaues;

    /**
     * @param vlaues the vlaues to set
     */
    public void setVlaues(List<CfgServiceValue> vlaues) {
        this.vlaues = vlaues;
    }

    /**
     * @return the vlaues
     */
    public List<CfgServiceValue> getVlaues() {
        return vlaues;
    }
}
