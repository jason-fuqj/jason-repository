package com.jason.book.domain;

/**
 * TODO: 管理员实体类
 * <p>
 * Created by Jason.Fu on 2020/5/10.
 */
public class Admin {
    // 用户ID
    private Long id;
    // 用户名
    private String userName;
    // 登录密码
    private String password;
    // 邮箱
    private String email;

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
