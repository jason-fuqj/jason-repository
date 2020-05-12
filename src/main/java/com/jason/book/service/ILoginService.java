package com.jason.book.service;

import com.alibaba.fastjson.JSONObject;

/**
 * TODO: 登录服务接口
 * <p>
 * Created by Jason.Fu on 2020/5/12.
 */
public interface ILoginService {
    /**
     * 登录
     * @param jsonObject
     * @return
     */
    JSONObject authLogin(JSONObject jsonObject);

    /**
     * 退出登录
     */
    JSONObject logout();

}
