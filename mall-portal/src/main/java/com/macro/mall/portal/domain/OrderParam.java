package com.macro.mall.portal.domain;

/**
 * 生成订单时传入的参数
 * Created by macro on 2018/8/30.
 */
public class OrderParam {
    //确认信息id
    private Long confirmid;
    //收货地址id
    private Long memberReceiveAddressId;
    //优惠券id
    private Long couponId;
    //使用的积分数
    private Integer useIntegration;
   

    public Long getMemberReceiveAddressId() {
        return memberReceiveAddressId;
    }

    public void setMemberReceiveAddressId(Long memberReceiveAddressId) {
        this.memberReceiveAddressId = memberReceiveAddressId;
    }

    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }
    /**
     * @param confirmid the confirmid to set
     */
    public void setConfirmid(Long confirmid) {
        this.confirmid = confirmid;
    }

    /**
     * @return the confirmid
     */
    public Long getConfirmid() {
        return confirmid;
    }

    public Integer getUseIntegration() {
        return useIntegration;
    }

    public void setUseIntegration(Integer useIntegration) {
        this.useIntegration = useIntegration;
    }
}
