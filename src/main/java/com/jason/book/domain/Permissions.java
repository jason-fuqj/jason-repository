package com.jason.book.domain;

/**
 * TODO: 权限类
 * <p>
 * Created by Jason.Fu on 2020/5/11.
 */
public class Permissions {
    // 权限id
    private String id;
    // 权限名称
    private String permissionsName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPermissionsName() {
        return permissionsName;
    }

    public void setPermissionsName(String permissionsName) {
        this.permissionsName = permissionsName;
    }
}
