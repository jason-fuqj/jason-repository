package com.jason.book.service;

import com.jason.book.domain.User;
import com.alibaba.fastjson.JSONObject;

/**
 * TODO:
 * <p>
 * Created by Jason.Fu on 2020/5/10.
 */
public interface IUserService {

    public JSONObject getUserByName(JSONObject jsonObject);

    public JSONObject addUser(JSONObject jsonObject);

    public JSONObject deleteByPrimaryKey(JSONObject jsonObject);

    public JSONObject updateByPrimaryKey(JSONObject jsonObject);

    public JSONObject getUserPermissions(JSONObject jsonObject);

    public JSONObject getAllPermissions();

    public JSONObject getAllRoles();

}
