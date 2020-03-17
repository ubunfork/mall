package com.macro.mall.dto;
import javax.validation.constraints.NotEmpty;
import io.swagger.annotations.ApiModelProperty;



/**
 * 用户登录参数
 * Created by macro on 2018/4/26.
 */

public class UmsAdminRegisterParam {

    @ApiModelProperty(value = "用户名", required = true)
    @NotEmpty(message = "用户名不能为空")
    private String username;

    @ApiModelProperty(value = "密码", required = true)
    @NotEmpty(message = "密码不能为空")
    private String password;

    @ApiModelProperty(value = "验证码")
    private String authCode;

    @ApiModelProperty(value = "手机号码")
    private String phone;

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param authCode the authCode to set
     */
    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    /**
     * @return the authCode
     */
    public String getAuthCode() {
        return authCode;
    }
    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }
    

}