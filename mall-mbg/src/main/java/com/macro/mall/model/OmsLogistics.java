package com.macro.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;

public class OmsLogistics implements Serializable {
    private Long id;

    @ApiModelProperty(value = "物流单号")
    private String logisticsnum;

    @ApiModelProperty(value = "订单id")
    private Long orderid;

    @ApiModelProperty(value = "物流公司")
    private String logisticscom;

    @ApiModelProperty(value = "物流价格")
    private BigDecimal price;

    @ApiModelProperty(value = "付款人")
    private String payer;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogisticsnum() {
        return logisticsnum;
    }

    public void setLogisticsnum(String logisticsnum) {
        this.logisticsnum = logisticsnum;
    }

    public Long getOrderid() {
        return orderid;
    }

    public void setOrderid(Long orderid) {
        this.orderid = orderid;
    }

    public String getLogisticscom() {
        return logisticscom;
    }

    public void setLogisticscom(String logisticscom) {
        this.logisticscom = logisticscom;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", logisticsnum=").append(logisticsnum);
        sb.append(", orderid=").append(orderid);
        sb.append(", logisticscom=").append(logisticscom);
        sb.append(", price=").append(price);
        sb.append(", payer=").append(payer);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}