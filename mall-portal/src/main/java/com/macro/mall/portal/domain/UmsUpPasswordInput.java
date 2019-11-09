package com.macro.mall.portal.domain;

import io.swagger.annotations.ApiModelProperty;

public class UmsUpPasswordInput{

    @ApiModelProperty(value = "手机号码")
    private String telephone;

    @ApiModelProperty(value = "验证码")
    private String authCode;

    @ApiModelProperty(value = "新密码")
    private String password;
  

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

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }
    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}