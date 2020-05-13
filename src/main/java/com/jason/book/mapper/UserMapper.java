package com.jason.book.mapper;

import com.jason.book.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * TODO: 用户mapper
 * <p>
 * Created by Jason.Fu on 2020/5/10.
 */
@Component
@Mapper
public interface UserMapper {
    /**
     * 添加用户
     * @param jsonObject
     * @return
     */
    int addUser(JSONObject jsonObject);

    /**
     * 删除用户
     * @param jsonObject
     * @return
     */
    int deleteByPrimaryKey(JSONObject jsonObject);

    /**
     * 更新用户信息
     * @param jsonObject
     * @return
     */
    int updateByPrimaryKey(JSONObject jsonObject);

    /**
     * 根据用户名查询
     * @param jsonObject
     * @return
     */
    JSONObject selectByName(JSONObject jsonObject);

    /**
     * 分页查询用户
     * @param jsonObject
     * @return
     */
    List<User> selectByPage(JSONObject jsonObject);

    /**
     * 查询用户总数
     */
    int getUserCount();
}
