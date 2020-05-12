package com.jason.book.config;

import com.alibaba.fastjson.JSONException;
import com.jason.book.constants.Constants;
import com.jason.book.domain.Permissions;
import com.jason.book.domain.Role;
import com.jason.book.domain.User;
import com.jason.book.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

/**
 * TODO: 授权认证
 * <p>
 * Created by Jason.Fu on 2020/5/11.
 */
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    IUserService iUserService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        SimpleAuthorizationInfo authorizationInfo = null;
        try {
            Session session = SecurityUtils.getSubject().getSession();
            //查询用户的权限
            JSONObject permission = (JSONObject) session.getAttribute(Constants.SESSION_USER_PERMISSION);
            //为当前用户设置角色和权限
            authorizationInfo = new SimpleAuthorizationInfo();
            authorizationInfo.addStringPermissions((Collection<String>) permission.get("permissionList"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //加这一步的目的是在Post请求的时候会先进认证，然后在到请求
        if (authenticationToken.getPrincipal() == null) {
            return null;
        }
        // 获取用户名
        String userName = authenticationToken.getPrincipal().toString();
        // 获取用户信息
        JSONObject user = iUserService.getUserByName(userName);
        if (user == null) {
            //这里返回后会报出对应异常
            throw new UnknownAccountException();
        } else {
            String password = user.getString("password");
            // 加[盐] 一般以用户名或随机数为盐
            ByteSource salt = ByteSource.Util.bytes(userName);

            //这里验证authenticationToken和simpleAuthenticationInfo的信息
            SimpleAuthenticationInfo simpleAuthenticationInfo = null;
            try {
                simpleAuthenticationInfo = new SimpleAuthenticationInfo(userName, password, salt, this.getName());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            //session中不需要保存密码
            user.remove("password");
            //将用户信息放入session中
            SecurityUtils.getSubject().getSession().setAttribute(Constants.SESSION_USER_INFO, user);
            return simpleAuthenticationInfo;
        }
    }
}
