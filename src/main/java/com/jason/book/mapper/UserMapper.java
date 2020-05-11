package com.jason.book.mapper;

import com.jason.book.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * TODO:
 * <p>
 * Created by Jason.Fu on 2020/5/10.
 */
@Component
@Mapper
public interface UserMapper {
    /**
     * 添加用户
     * @param record
     * @return
     */
    int addUser(User record);

    /**
     * 删除用户
     * @param userId
     * @return
     */
    int deleteByPrimaryKey(Long userId);

    /**
     * 更新用户信息
     * @param record
     * @return
     */
    int updateByPrimaryKey(User record);

    /**
     * 根据用户名和密码查询
     * @param username
     * @param password
     * @return
     */
    User selectByNameAndPwd(String username,String password);

    /**
     * 分页查询用户
     * @param pageNumber
     * @param pageSize
     * @return
     */
    List<User> selectByPage(@Param("pageNumber") int pageNumber, @Param("pageSize")int pageSize);

    /**
     * 查询用户总数
     */
    int getUserCount();
}
