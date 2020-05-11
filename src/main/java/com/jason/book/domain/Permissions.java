package com.jason.book.domain;

/**
 * TODO: 权限类
 * <p>
 * Created by Jason.Fu on 2020/5/11.
 */
public class Permissions {
    // 权限id
    private String permissionsId;
    // 权限代码
    private String permissionsCode;
    // 权限名称
    private String permissionsName;
    // 菜单代码
    private String menuCode;
    // 菜单名称
    private String menuName;
    // 是否本菜单必选权限
    private String isRequired;

    public String getPermissionsCode() {
        return permissionsCode;
    }

    public void setPermissionsCode(String permissionsCode) {
        this.permissionsCode = permissionsCode;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getIsRequired() {
        return isRequired;
    }

    public void setIsRequired(String isRequired) {
        this.isRequired = isRequired;
    }

    public String getPermissionsId() {
        return permissionsId;
    }

    public void setPermissionsId(String permissionsId) {
        this.permissionsId = permissionsId;
    }

    public String getPermissionsName() {
        return permissionsName;
    }

    public void setPermissionsName(String permissionsName) {
        this.permissionsName = permissionsName;
    }
}
