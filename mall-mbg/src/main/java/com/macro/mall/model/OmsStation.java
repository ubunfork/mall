package com.macro.mall.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;

public class OmsStation implements Serializable {
    private Long id;

    @ApiModelProperty(value = "自提点id")
    private Long stationid;

    @ApiModelProperty(value = " 1->配送中 2->待取货 3->已取货 4->已结算")
    private Integer status;

    @ApiModelProperty(value = "物流id")
    private Long logisticsid;

    @ApiModelProperty(value = "订单id")
    private Long orderid;

    @ApiModelProperty(value = "自提点价格")
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

    public Long getStationid() {
        return stationid;
    }

    public void setStationid(Long stationid) {
        this.stationid = stationid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getLogisticsid() {
        return logisticsid;
    }

    public void setLogisticsid(Long logisticsid) {
        this.logisticsid = logisticsid;
    }

    public Long getOrderid() {
        return orderid;
    }

    public void setOrderid(Long orderid) {
        this.orderid = orderid;
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
        sb.append(", stationid=").append(stationid);
        sb.append(", status=").append(status);
        sb.append(", logisticsid=").append(logisticsid);
        sb.append(", orderid=").append(orderid);
        sb.append(", price=").append(price);
        sb.append(", payer=").append(payer);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}