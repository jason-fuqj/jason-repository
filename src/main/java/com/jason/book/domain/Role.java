package com.jason.book.domain;

import java.util.Set;

/**
 * TODO: 用户角色
 * <p>
 * Created by Jason.Fu on 2020/5/11.
 */
public class Role {
    // 角色id
    private String id;
    // 角色名称
    private String roleName;
    // 角色对应的权限集合
    private Set<Permissions> permissions;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<Permissions> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permissions> permissions) {
        this.permissions = permissions;
    }
}
