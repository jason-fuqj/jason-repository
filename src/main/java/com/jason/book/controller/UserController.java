package com.jason.book.controller;

import com.alibaba.fastjson.JSONObject;
import com.jason.book.domain.BorrowHistory;
import com.jason.book.domain.User;
import com.jason.book.service.IBorrowService;
import com.jason.book.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * TODO: 用户控制类
 * <p>
 * Created by Jason.Fu on 2020/5/11.
 */
@Api(value = "UserController",tags = "用户、借还模块接口")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService iUserService;

    @Autowired
    IBorrowService iBorrowService;

    @ApiOperation(value = "查询用户信息",notes = "查询用户信息接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", required = true ,dataType = "string")
    })
    @RequiresPermissions("user:list")
    @GetMapping(value = "/getList")
    public JSONObject getUser(User user) {
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(user);
        //获取用户信息
        return iUserService.getUserByName(jsonObject);
    }

    @ApiOperation(value = "查询用户权限",notes = "查询用户权限接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", required = true ,dataType = "string")
    })
    @GetMapping("/getUserPermission")
    public JSONObject getUserPermission(User user) {
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(user);
        //获取用户权限
        return iUserService.getUserPermissions(jsonObject);
    }

    @ApiOperation(value = "添加用户",notes = "新增用户接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", required = true ,dataType = "string"),
            @ApiImplicitParam(name = "password", value = "登录密码", required = true ,dataType = "string"),
            @ApiImplicitParam(name = "email", value = "邮箱", required = false ,dataType = "string"),
            @ApiImplicitParam(name = "roleId", value = "角色ID", required = false ,dataType = "string"),
    })
    @RequiresPermissions("user:add")
    @PostMapping("/addUser")
    public JSONObject addUser(User user) {
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(user);
        //添加用户信息
        return iUserService.addUser(jsonObject);
    }

    @ApiOperation(value = "修改用户",notes = "修改用户信息接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", required = true ,dataType = "string"),
            @ApiImplicitParam(name = "status", value = "用户状态", required = false ,dataType = "string"),
            @ApiImplicitParam(name = "email", value = "邮箱", required = false ,dataType = "string"),
            @ApiImplicitParam(name = "roleId", value = "角色ID", required = false ,dataType = "string"),
    })
    @RequiresPermissions("user:update")
    @PostMapping("/updateUser")
    public JSONObject updateUser(User user) {
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(user);
        //更新用户信息
        return iUserService.updateByPrimaryKey(jsonObject);
    }

    @ApiOperation(value = "删除用户",notes = "删除用户信息接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true ,dataType = "string"),
    })
    @RequiresPermissions("user:delete")
    @PostMapping("/deleteUser")
    public JSONObject deleteUser(User user) {
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(user);
        //删除用户信息
        return iUserService.deleteByPrimaryKey(jsonObject);
    }

    @ApiOperation(value = "查询角色列表",notes = "查询所有角色接口")
    @RequiresPermissions("role:list")
    @GetMapping("/getAllRoles")
    public JSONObject getAllRoles(User user) {
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(user);
        //查询所有角色
        return iUserService.getAllRoles();
    }

    @ApiOperation(value = "用户借书",notes = "用户借书接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true ,dataType = "string"),
            @ApiImplicitParam(name = "bookId", value = "图书ID", required = true ,dataType = "string")
    })
    @RequiresPermissions("borrow:add")
    @PostMapping("/borrowBook")
    public JSONObject borrowBook(BorrowHistory borrowHistory) {
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(borrowHistory);
        return iBorrowService.borrowBook(jsonObject);
    }

    @ApiOperation(value = "用户还书",notes = "用户还书接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true ,dataType = "string"),
            @ApiImplicitParam(name = "bookId", value = "图书ID", required = true ,dataType = "string")
    })
    @RequiresPermissions("borrow:update")
    @PostMapping("/returnBook")
    public JSONObject returnBook(BorrowHistory borrowHistory) {
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(borrowHistory);
        return iBorrowService.returnBook(jsonObject);
    }

    @ApiOperation(value = "用户借还记录列表",notes = "查询用户借还记录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true ,dataType = "string")
    })
    @RequiresPermissions("borrow:list")
    @GetMapping("/getBorrowList")
    public JSONObject getBorrowList(BorrowHistory borrowHistory){
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(borrowHistory);
        return iBorrowService.selectBorrowHistoryByPage(jsonObject);
    }
}
