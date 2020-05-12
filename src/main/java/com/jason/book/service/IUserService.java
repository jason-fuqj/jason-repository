package com.jason.book.service;

import com.jason.book.domain.User;
import com.alibaba.fastjson.JSONObject;

/**
 * TODO:
 * <p>
 * Created by Jason.Fu on 2020/5/10.
 */
public interface IUserService {

    public JSONObject getUserByName(String userName);

    public int addUser(User user);

    public int deleteByPrimaryKey(Long userId);

    public int updateByPrimaryKey(User user);
}
