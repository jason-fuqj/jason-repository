package com.jason.book.controller;

import com.alibaba.fastjson.JSONObject;
import com.jason.book.domain.User;
import com.jason.book.service.ILoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO: 登录控制器
 * <p>
 * Created by Jason.Fu on 2020/5/12.
 */
@RestController
public class LoginController {
    @Autowired
    ILoginService iLoginService;

    @RequestMapping("/login")
    public JSONObject login(User user) {
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(user);
        return iLoginService.authLogin(jsonObject);
    }

    @RequestMapping("logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "/login";
    }

}
