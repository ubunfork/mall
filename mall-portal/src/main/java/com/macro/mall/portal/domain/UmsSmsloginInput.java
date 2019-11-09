package com.macro.mall.portal.domain;

import io.swagger.annotations.ApiModelProperty;

public class UmsSmsloginInput{

    @ApiModelProperty(value = "手机号码")
    private String telephone;

    @ApiModelProperty(value = "验证码")
    private String authCode;


  

    /**
     * @return the authCode
     */
    public String getAuthCode() {
        return authCode;
    }
    /**
     * @param authCode the authCode to set
     */
    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }
    /**
     * @return the telephone
     */
    public String getTelephone() {
        return telephone;
    }
    /**
     * @param telephone the telephone to set
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

}