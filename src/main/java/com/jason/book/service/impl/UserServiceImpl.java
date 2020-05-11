package com.jason.book.service.impl;

import com.jason.book.mapper.UserMapper;
import com.jason.book.service.IUserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO: 用户服务实现类
 * <p>
 * Created by Jason.Fu on 2020/5/10.
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public JSONObject getUserByName(String name, String password) {

        return userMapper.selectByNameAndPwd(name,password);
    }
}
