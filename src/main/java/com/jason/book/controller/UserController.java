package com.jason.book.controller;

import com.alibaba.fastjson.JSONException;
import com.jason.book.domain.User;
import com.jason.book.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * TODO:
 * <p>
 * Created by Jason.Fu on 2020/5/11.
 */
@RestController
public class UserController {

    @Autowired
    IUserService iUserService;

    @RequestMapping("/getUser")
    public String getUser(User user) {
        //添加用户认证信息
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
                user.getUserName(),
                user.getPassword()
        );
        try {
            //进行验证，这里可以捕获异常，然后返回对应信息
            subject.login(usernamePasswordToken);
//            subject.checkRole("admin");
//            subject.checkPermissions("query", "add");

            //获取用户信息
            String userName = user.getUserName();
            JSONObject record = iUserService.getUserByName(userName);
            int roleId = 0;
            if(record != null){
                roleId = record.getInteger("roleId");
            }
            if(roleId == 1){
                // 管理员
            }else{
                // 普通用户
            }


        } catch (AuthenticationException e) {
            e.printStackTrace();
            return "账号或密码错误！";
        } catch (AuthorizationException e) {
            e.printStackTrace();
            return "没有权限";
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "login success";
    }

}
