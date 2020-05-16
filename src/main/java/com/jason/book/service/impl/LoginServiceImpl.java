package com.jason.book.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.jason.book.domain.User;
import com.jason.book.domain.vo.UserVo;
import com.jason.book.mapper.UserMapper;
import com.jason.book.service.ILoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO: 登录服务实现类
 * <p>
 * Created by Jason.Fu on 2020/5/12.
 */
@Service
public class LoginServiceImpl implements ILoginService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User authLogin(UserVo userVo) {
        String username = userVo.getUserName();
        String password = userVo.getPassword();
        Subject currentUser = SecurityUtils.getSubject();
        // 身份认证
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 登录认证
        currentUser.login(token);
        //获取用户信息
        User user = userMapper.selectByName(username);
        if (user != null){
            user.setPassword("");
        }
        return user;
    }

    @Override
    public void logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
    }
}
