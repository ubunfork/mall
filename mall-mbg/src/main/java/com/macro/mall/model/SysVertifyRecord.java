package com.macro.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class SysVertifyRecord implements Serializable {
    private Long id;

    @ApiModelProperty(value = "审核人id")
    private Long verId;

    @ApiModelProperty(value = "审核对应的订单id")
    private Long defId;

    @ApiModelProperty(value = "审核对应类型 1->自提点申请")
    private Integer type;

    @ApiModelProperty(value = "对应的审核状态")
    private Integer status;

    @ApiModelProperty(value = "反馈详情")
    private String detail;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVerId() {
        return verId;
    }

    public void setVerId(Long verId) {
        this.verId = verId;
    }

    public Long getDefId() {
        return defId;
    }

    public void setDefId(Long defId) {
        this.defId = defId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", verId=").append(verId);
        sb.append(", defId=").append(defId);
        sb.append(", type=").append(type);
        sb.append(", status=").append(status);
        sb.append(", detail=").append(detail);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}