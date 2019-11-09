package com.macro.mall.portal.domain;

import io.swagger.annotations.ApiModelProperty;

public class PassLoginInput{
  
    @ApiModelProperty(value = "用户名/手机号码")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;


    /**
     * @return the userName
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
}