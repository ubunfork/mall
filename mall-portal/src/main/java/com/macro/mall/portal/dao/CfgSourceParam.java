package com.macro.mall.portal.dao;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 订单查询参数
 * Created by macro on 2018/10/11.
 */
@Getter
@Setter
public class CfgSourceParam {
    @ApiModelProperty(value = "配置类型")
    private int typeid;
    @ApiModelProperty(value = "版本号")
    private String verstion;
    @ApiModelProperty(value = "平台")
    private String platform;

    public int getTypeid() {
        return typeid;
    }
    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    public String getVerstion() {
        return verstion;
    }
    public void setVerstion(String verstion) {
        this.verstion = verstion;
    }

    public String getPlatform() {
        return platform;
    }
    public void setPlatform(String platform) {
        this.platform = platform;
    }

}