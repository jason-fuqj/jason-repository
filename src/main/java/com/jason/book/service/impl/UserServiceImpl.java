package com.jason.book.service.impl;

import com.jason.book.domain.User;
import com.jason.book.mapper.UserMapper;
import com.jason.book.service.IUserService;
import com.alibaba.fastjson.JSONObject;
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
    public JSONObject getUserByName(String userName) {

        return userMapper.selectByName(userName);
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public int deleteByPrimaryKey(Long userId) {
        return userMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public int updateByPrimaryKey(User user) {
        return userMapper.updateByPrimaryKey(user);
    }
}
