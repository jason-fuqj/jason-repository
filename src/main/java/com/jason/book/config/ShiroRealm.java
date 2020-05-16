package com.jason.book.config;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.jason.book.constants.Constants;
import com.jason.book.domain.User;
import com.jason.book.mapper.PermissionMapper;
import com.jason.book.mapper.UserMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * TODO: 授权认证
 * <p>
 * Created by Jason.Fu on 2020/5/11.
 */
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    UserMapper userMapper;

    @Autowired
    PermissionMapper permissionMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        SimpleAuthorizationInfo authorizationInfo = null;
        try {
            Session session = SecurityUtils.getSubject().getSession();
            // 查询用户的权限
            JSONObject permission = (JSONObject) session.getAttribute(Constants.SESSION_USER_PERMISSION);
            // 为当前用户设置角色和权限
            authorizationInfo = new SimpleAuthorizationInfo();
            Collection<String> collection = (Collection<String>) permission.get("permissionList");
            List<String> list = new ArrayList<String>(collection);
            for (int i=0;i<list.size();i++){
                authorizationInfo.addStringPermission(String.valueOf(list.get(i)));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 加这一步的目的是在Post请求的时候会先进认证，然后在到请求
        if (authenticationToken.getPrincipal() == null) {
            throw new UnauthenticatedException();
        }
        // 获取用户名
        String userName = authenticationToken.getPrincipal().toString();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userName",userName);
        // 获取用户信息
        User user = userMapper.selectByName(userName);
        if (user == null) {
            // 这里返回后会报出对应异常
            throw new UnknownAccountException();
        } else {
            String password = user.getPassword();

            // 这里验证authenticationToken和simpleAuthenticationInfo的信息
            SimpleAuthenticationInfo simpleAuthenticationInfo = null;
            try {
                //将查询到的用户账号和密码存放到 simpleAuthenticationInfo用于后面的权限判断。第三个参数传入用户输入的用户名。
                simpleAuthenticationInfo = new SimpleAuthenticationInfo(userName, password, this.getName());
                //设置盐，用来核对密码
                simpleAuthenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(user.getUserName()));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            // session中不需要保存密码
            user.setPassword("");
            // 将用户信息放入session中
            SecurityUtils.getSubject().getSession().setAttribute(Constants.SESSION_USER_INFO, user);
            // 查询用户权限
            JSONObject  permissionList = permissionMapper.getUserPermission(userName);
            SecurityUtils.getSubject().getSession().setAttribute(Constants.SESSION_USER_PERMISSION,permissionList);
            return simpleAuthenticationInfo;
        }
    }
}
