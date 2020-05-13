package com.jason.book.service.impl;

import com.jason.book.constants.ErrorCodeEnum;
import com.jason.book.mapper.UserMapper;
import com.jason.book.service.ILoginService;
import com.alibaba.fastjson.JSONObject;
import com.jason.book.utils.ResultUtil;
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
    public JSONObject authLogin(JSONObject jsonObject) {
        String username = jsonObject.getString("userName");
        String password = jsonObject.getString("password");
        JSONObject record = new JSONObject();
        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            currentUser.login(token);
            //获取用户信息
            record = userMapper.selectByName(jsonObject);
            record.remove("password");
        } catch (AuthenticationException e) {
            // 账号或密码有误
            return ResultUtil.errorJson(ErrorCodeEnum.E_10003);
        }catch (AuthorizationException e){
            // 权限不足
            return ResultUtil.errorJson(ErrorCodeEnum.E_502);
        }
        return ResultUtil.successJson(record);
    }

    @Override
    public JSONObject logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        JSONObject record = new JSONObject();
        return ResultUtil.successJson(record);
    }
}
