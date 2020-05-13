package com.jason.book.domain;

import io.swagger.annotations.ApiModelProperty;

/**
 * TODO: 权限类
 * <p>
 * Created by Jason.Fu on 2020/5/11.
 */
public class Permissions {
    // 权限id
    @ApiModelProperty(value = "权限id", name = "id")
    private Integer id;
    // 权限代码
    @ApiModelProperty(value = "权限代码", name = "permissionCode")
    private String permissionCode;
    // 权限名称
    @ApiModelProperty(value = "权限名称", name = "permissionName")
    private String permissionName;
    // 菜单代码
    @ApiModelProperty(value = "菜单代码", name = "menuCode")
    private String menuCode;
    // 菜单名称
    @ApiModelProperty(value = "菜单名称", name = "menuName")
    private String menuName;
    // 是否本菜单必选权限
    @ApiModelProperty(value = "是否本菜单必选权限", name = "isRequired")
    private int isRequired;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIsRequired() {
        return isRequired;
    }

    public void setIsRequired(int isRequired) {
        this.isRequired = isRequired;
    }

    public String getPermissionCode() {
        return permissionCode;
    }

    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }
}
