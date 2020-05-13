package com.jason.book.service.impl;

import com.jason.book.constants.Constants;
import com.jason.book.domain.User;
import com.jason.book.mapper.PermissionMapper;
import com.jason.book.mapper.RoleMapper;
import com.jason.book.mapper.UserMapper;
import com.jason.book.service.IUserService;
import com.alibaba.fastjson.JSONObject;
import com.jason.book.utils.ResultUtil;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO: 用户服务实现类
 * <p>
 * Created by Jason.Fu on 2020/5/10.
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    PermissionMapper permissionMapper;

    @Autowired
    RoleMapper roleMapper;

    @Override
    public JSONObject getUserByName(JSONObject jsonObject) {
        JSONObject record = new JSONObject();
        record = userMapper.selectByName(jsonObject);
        return ResultUtil.successJson(record);
    }

    @Override
    public JSONObject addUser(JSONObject jsonObject) {
        // 获取用户名，用于生成盐
        String userName = jsonObject.getString("userName");
        String password = jsonObject.getString("password");
        //生成盐（需要存入数据库中）
        ByteSource salt = ByteSource.Util.bytes(userName);
        //将原始密码加盐（上面生成的盐），并且用md5算法加密三次，将最后结果存入数据库中
        String encryptedPwd = new Md5Hash(password,salt, Constants.HASH_ITERATIONS).toString();
        jsonObject.put("password",encryptedPwd);
        jsonObject.put("pwdRandom",salt.toString());
        int result =  userMapper.addUser(jsonObject);

        JSONObject record = new JSONObject();
        record.put("result",result);
        return ResultUtil.successJson(record);
    }

    @Override
    public JSONObject deleteByPrimaryKey(JSONObject jsonObject) {
        int result =  userMapper.deleteByPrimaryKey(jsonObject);
        JSONObject record = new JSONObject();
        record.put("result",result);
        return ResultUtil.successJson(record);
    }

    @Override
    public JSONObject updateByPrimaryKey(JSONObject jsonObject) {
        int result =  userMapper.updateByPrimaryKey(jsonObject);
        JSONObject record = new JSONObject();
        record.put("result",result);
        return ResultUtil.successJson(record);
    }

    @Override
    public JSONObject getUserPermissions(JSONObject jsonObject) {
        JSONObject permission = permissionMapper.getUserPermission(jsonObject);
        return ResultUtil.successJson(permission);
    }

    @Override
    public JSONObject getAllPermissions() {
        List<JSONObject> list = permissionMapper.getAllPermission();
        return ResultUtil.successJson(list);
    }

    @Override
    public JSONObject getAllRoles() {
        List<JSONObject> list = roleMapper.getRoles();
        return ResultUtil.successJson(list);
    }
}
