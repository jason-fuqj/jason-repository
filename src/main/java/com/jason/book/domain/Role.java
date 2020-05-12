package com.jason.book.domain;

import java.util.Date;
import java.util.Set;

/**
 * TODO: 用户角色
 * <p>
 * Created by Jason.Fu on 2020/5/11.
 */
public class Role {
    // 角色id
    private Integer roleId;
    // 角色名称
    private String roleName;
    // 创建时间
    private Date createTime;
    // 更新时间
    private Date updateTime;
    // 状态
    private String status;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
