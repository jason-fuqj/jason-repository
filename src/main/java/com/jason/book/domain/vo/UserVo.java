package com.jason.book.domain.vo;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;


public class UserVo extends PageVo{

    @ApiModelProperty(value = "用户ID", name = "userId")
    private Integer userId;

    @ApiModelProperty(value = "用户名", name = "userName",  example = "admin")
    private String userName;

    @ApiModelProperty(value = "登录密码", name = "password",  example = "123456")
    private String password;

    @ApiModelProperty(value = "邮箱", name = "email")
    private String email;

    @ApiModelProperty(value = "用户角色", name = "roleId")
    private Integer roleId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
