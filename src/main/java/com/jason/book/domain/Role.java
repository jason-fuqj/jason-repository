package com.jason.book.domain;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * TODO: 用户角色
 * <p>
 * Created by Jason.Fu on 2020/5/11.
 */
public class Role implements Serializable {
    // 角色id
    @ApiModelProperty(value = "角色id", name = "roleId")
    private Integer roleId;
    // 角色名称
    @ApiModelProperty(value = "角色名称", name = "roleName")
    private String roleName;
    // 创建时间
    @ApiModelProperty(value = "创建时间", name = "createTime")
    private Date createTime;
    // 更新时间
    @ApiModelProperty(value = "更新时间", name = "updateTime")
    private Date updateTime;
    // 状态
    @ApiModelProperty(value = "角色状态", name = "status")
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
