package com.jason.book.service;

import com.jason.book.domain.User;
import org.json.JSONObject;

/**
 * TODO:
 * <p>
 * Created by Jason.Fu on 2020/5/10.
 */
public interface IUserService {

    JSONObject getUserByName(String name, String password);
}
