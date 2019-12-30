package com.macro.mall.portal.domain;

import io.swagger.annotations.ApiModelProperty;

public class UmsRegisterInput{
    //@RequestParam String username,
    // @RequestParam String password,
    // @RequestParam String telephone,
    // @RequestParam String authCode,
    // @RequestParam (value = "reccode", required = false) String reccode
    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "手机号")
    private String telephone;

    @ApiModelProperty(value = "验证码")
    private String authCode;

    @ApiModelProperty(value = "邀请码")
    private String reccode;

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
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
     * @return the reccode
     */
    public String getReccode() {
        return reccode;
    }
    /**
     * @param reccode the reccode to set
     */
    public void setReccode(String reccode) {
        this.reccode = reccode;
    }

}