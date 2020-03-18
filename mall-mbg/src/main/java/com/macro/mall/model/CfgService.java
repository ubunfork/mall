package com.macro.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class CfgService implements Serializable {
    private Integer id;

    @ApiModelProperty(value = "标题")
    private String name;

    @ApiModelProperty(value = "设置值")
    private String value;

    @ApiModelProperty(value = "废弃（20200115） 可选json参数[{key:value}]，如果为空则为string")
    private String maybe;

    @ApiModelProperty(value = "配置父id")
    private Integer parentid;

    @ApiModelProperty(value = "关键key")
    private String cfgkey;

    @ApiModelProperty(value = "值类型，0 用户输入 1:有可选值")
    private Integer valuetype;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getMaybe() {
        return maybe;
    }

    public void setMaybe(String maybe) {
        this.maybe = maybe;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public String getCfgkey() {
        return cfgkey;
    }

    public void setCfgkey(String cfgkey) {
        this.cfgkey = cfgkey;
    }

    public Integer getValuetype() {
        return valuetype;
    }

    public void setValuetype(Integer valuetype) {
        this.valuetype = valuetype;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", value=").append(value);
        sb.append(", maybe=").append(maybe);
        sb.append(", parentid=").append(parentid);
        sb.append(", cfgkey=").append(cfgkey);
        sb.append(", valuetype=").append(valuetype);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}