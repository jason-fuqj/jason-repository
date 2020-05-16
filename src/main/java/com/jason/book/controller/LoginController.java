package com.jason.book.controller;

import com.jason.book.domain.User;
import com.jason.book.domain.vo.UserVo;
import com.jason.book.service.ILoginService;
import com.jason.book.utils.JasonResult;
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
@Api(value = "LoginController",tags = "登录模块接口")
@RestController
public class LoginController {
    @Autowired
    ILoginService iLoginService;

    @ApiOperation(value = "用户登录",notes = "用户登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", required = true ,dataType = "string"),
            @ApiImplicitParam(name = "password", value = "密码", required = true ,dataType = "string")})
    @RequestMapping(value = "/login" ,method = {RequestMethod.POST,RequestMethod.GET})
    public JasonResult login(
            @RequestParam(name = "userName") String userName,
            @RequestParam(name = "password") String password
            ) {
        UserVo userVo = new UserVo();
        userVo.setUserName(userName);
        userVo.setPassword(password);
        User user = iLoginService.authLogin(userVo);
        return JasonResult.success(user);
    }

    @ApiOperation(value = "退出登录",notes = "用户退出登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", required = true ,dataType = "string")})
    @RequestMapping(value = "/logout",method = {RequestMethod.POST,RequestMethod.GET})
    public JasonResult logout( @RequestParam(name = "userName") String userName) {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return JasonResult.success();
    }

}
