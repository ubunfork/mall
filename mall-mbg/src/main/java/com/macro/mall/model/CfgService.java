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

    @ApiModelProperty(value = "值类型，0 用户输入 1:有可选值")
    private Integer valueType;

    @ApiModelProperty(value = "关键key")
    private String cfgKey;

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

    public Integer getValueType() {
        return valueType;
    }

    public void setValueType(Integer valueType) {
        this.valueType = valueType;
    }

    public String getCfgKey() {
        return cfgKey;
    }

    public void setCfgKey(String cfgKey) {
        this.cfgKey = cfgKey;
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
        sb.append(", valueType=").append(valueType);
        sb.append(", cfgKey=").append(cfgKey);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}