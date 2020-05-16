package com.jason.book.service;

import com.alibaba.fastjson.JSONObject;
import com.jason.book.domain.User;
import com.jason.book.domain.vo.UserVo;
import com.jason.book.utils.JasonResult;

/**
 * TODO: 登录服务接口
 * <p>
 * Created by Jason.Fu on 2020/5/12.
 */
public interface ILoginService {
    /**
     * 登录
     * @param userVo
     * @return
     */
    User authLogin(UserVo userVo);

    /**
     * 退出登录
     */
    void logout();

}
