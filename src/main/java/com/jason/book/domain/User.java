package com.jason.book.domain;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * TODO: 用户实体类
 * <p>
 * Created by Jason.Fu on 2020/5/9.
 */
public class User implements Serializable {
    // 用户ID
    @ApiModelProperty(value = "用户ID", name = "userId")
    private Integer userId;

    @ApiModelProperty(value = "用户名", name = "userName",  example = "admin")
    private String userName;

    @ApiModelProperty(value = "登录密码", name = "password",  example = "123456")
    private String password;

    @ApiModelProperty(value = "邮箱", name = "email")
    private String email;
    // 用户状态：0-正常，1-注销
    @ApiModelProperty(value = "用户状态", name = "status")
    private Integer status;
    // 注册时间
    @ApiModelProperty(value = "添加时间", name = "createDate")
    private Date createDate;
    // 用户角色
    @ApiModelProperty(value = "用户角色", name = "roleId")
    private Integer roleId;

    @ApiModelProperty(value = "加密盐", name = "pwdRandom")
    private String pwdRandom;

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

    public String getPwdRandom() {
        return pwdRandom;
    }

    public void setPwdRandom(String pwdRandom) {
        this.pwdRandom = pwdRandom;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                ", createDate=" + createDate +
                ", roleId=" + roleId +
                ", pwdRandom='" + pwdRandom + '\'' +
                '}';
    }

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

}
