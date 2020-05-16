package com.jason.book.mapper;

import com.jason.book.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

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
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 删除用户
     * @param userId
     * @return
     */
    int deleteByPrimaryKey(Integer userId);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    int updateByPrimaryKey(User user);

    /**
     * 根据用户名查询
     * @param username
     * @return
     */
    User selectByName(String username);

    /**
     * 分页查询用户
     * @param paramMap
     * @return
     */
    List<User> selectByPage(Map paramMap);

}
