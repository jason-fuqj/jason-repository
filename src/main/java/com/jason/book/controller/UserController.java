package com.jason.book.controller;

import com.alibaba.fastjson.JSONObject;
import com.jason.book.domain.BorrowHistory;
import com.jason.book.domain.Role;
import com.jason.book.domain.User;
import com.jason.book.domain.vo.BorrowHistoryVo;
import com.jason.book.domain.vo.UserVo;
import com.jason.book.service.IBorrowService;
import com.jason.book.service.IUserService;
import com.jason.book.utils.JasonResult;
import com.jason.book.utils.One2Many;
import com.jason.book.utils.PageDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * TODO: 用户控制类
 * <p>
 * Created by Jason.Fu on 2020/5/11.
 */
@Api(value = "UserController",tags = "用户模块接口")
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
    @GetMapping(value = "/getUserInfo")
    public JasonResult getUserInfo(@RequestParam(name = "userName") String userName) {
        //获取用户信息
        User user = iUserService.getUserByName(userName);
        user.setPassword("");
        return JasonResult.success(user);
    }

    @ApiOperation(value = "查询用户权限",notes = "查询用户权限接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", required = true ,dataType = "string")
    })
    @GetMapping("/getUserPermission")
    public JasonResult getUserPermission(@RequestParam(name = "userName") String userName) {
        //获取用户权限
        One2Many permissions = iUserService.getUserPermissions(userName);
        return JasonResult.success(permissions);
    }

    @ApiOperation(value = "添加用户",notes = "新增用户接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", required = true ,dataType = "string"),
            @ApiImplicitParam(name = "password", value = "登录密码", required = true ,dataType = "string"),
            @ApiImplicitParam(name = "email", value = "邮箱", required = false ,dataType = "string"),
            @ApiImplicitParam(name = "roleId", value = "角色ID", required = true ,dataType = "string"),
    })
    @RequiresPermissions("user:add")
    @PostMapping("/addUser")
    public JasonResult addUser(
            @RequestParam(name = "userName") String userName,
            @RequestParam(name = "password") String password,
            @RequestParam(name = "email") String email,
            @RequestParam(name = "roleId") Integer roleId
    ) {
        UserVo userVo = new UserVo();
        userVo.setUserName(userName);
        userVo.setPassword(password);
        userVo.setRoleId(roleId);
        userVo.setEmail(email);
        //添加用户信息
        int result = iUserService.addUser(userVo);
        Map<String,Integer> map = new HashMap<>();
        map.put("result",result);
        return JasonResult.success(map);
    }

    @ApiOperation(value = "修改用户",notes = "修改用户信息接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", required = true ,dataType = "string"),
            @ApiImplicitParam(name = "password", value = "登录密码", required = false ,dataType = "string"),
            @ApiImplicitParam(name = "email", value = "邮箱", required = false ,dataType = "string"),
            @ApiImplicitParam(name = "roleId", value = "角色ID", required = false ,dataType = "string"),
    })
    @RequiresPermissions("user:update")
    @PostMapping("/updateUser")
    public JasonResult updateUser(
            @RequestParam(name = "userName") String userName,
            @RequestParam(name = "password") String password,
            @RequestParam(name = "email") String email,
            @RequestParam(name = "roleId") Integer roleId
    ) {
        UserVo userVo = new UserVo();
        userVo.setUserName(userName);
        userVo.setPassword(password);
        userVo.setRoleId(roleId);
        userVo.setEmail(email);
        //更新用户信息
        int result = iUserService.updateByPrimaryKey(userVo);
        Map<String,Integer> map = new HashMap<>();
        map.put("result",result);
        return JasonResult.success(map);
    }

    @ApiOperation(value = "删除用户",notes = "删除用户信息接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true ,dataType = "string"),
    })
    @RequiresPermissions("user:delete")
    @PostMapping("/deleteUser")
    public JasonResult deleteUser(@RequestParam(name = "userId") Integer userId) {
        //删除用户信息
        int result = iUserService.deleteByPrimaryKey(userId);
        Map<String,Integer> map = new HashMap<>();
        map.put("result",result);
        return JasonResult.success(map);
    }

    @ApiOperation(value = "查询角色列表",notes = "查询所有角色接口")
    @RequiresPermissions("role:list")
    @GetMapping("/getAllRoles")
    public JasonResult getAllRoles() {
        //查询所有角色
        List<Role> list = iUserService.getAllRoles();
        return JasonResult.success(list);
    }


}
