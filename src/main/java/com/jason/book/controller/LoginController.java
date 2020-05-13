package com.jason.book.controller;

import com.alibaba.fastjson.JSONObject;
import com.jason.book.domain.User;
import com.jason.book.service.ILoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * TODO: 登录控制器
 * <p>
 * Created by Jason.Fu on 2020/5/12.
 */
@Api(value = "LoginController",tags = "登录模块")
@RestController
public class LoginController {
    @Autowired
    ILoginService iLoginService;

    @ApiOperation(value = "用户登录",notes = "用户登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", required = true ,dataType = "string"),
            @ApiImplicitParam(name = "password", value = "密码", required = true ,dataType = "string")})
    @RequestMapping(value = "/login",method = {RequestMethod.POST,RequestMethod.GET})
    public JSONObject login(User user) {
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(user);
        return iLoginService.authLogin(jsonObject);
    }

    @ApiOperation(value = "退出登录",notes = "用户退出登录接口")
    @PostMapping("/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "/login";
    }

}
