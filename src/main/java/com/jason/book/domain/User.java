package com.jason.book.domain;

import java.util.Date;
import java.util.Set;

/**
 * TODO: 用户借还实体类
 * <p>
 * Created by Jason.Fu on 2020/5/9.
 */
public class User {
    // 用户ID
    private Long id;
    // 用户名
    private String userName;
    // 登录密码
    private String password;
    // 邮箱
    private String email;
    // 用户状态：0-正常，1-注销
    private Integer status;
    // 注册时间
    private Date createDate;
    // 用户角色
    private Set<Role> roles;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                ", createDate=" + createDate +
                ", roles=" + roles +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
