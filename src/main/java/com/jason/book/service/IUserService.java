package com.jason.book.service;

import com.jason.book.domain.Permissions;
import com.jason.book.domain.Role;
import com.jason.book.domain.User;
import com.alibaba.fastjson.JSONObject;
import com.jason.book.domain.vo.UserVo;
import com.jason.book.utils.One2Many;
import com.jason.book.utils.PageDto;

import java.util.List;
import java.util.Map;

/**
 * TODO:
 * <p>
 * Created by Jason.Fu on 2020/5/10.
 */
public interface IUserService {

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    public User getUserByName(String username);

    /**
     * 添加新用户
     * @param user
     * @return
     */
    public int addUser(UserVo user);

    /**
     * 删除用户
     * @param userId
     * @return
     */
    public int deleteByPrimaryKey(Integer userId);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    public int updateByPrimaryKey(UserVo user);

    /**
     * 获取用户权限
     * @param userName
     * @return
     */
    public One2Many getUserPermissions(String userName);

    /**
     * 获取所有权限列表
     * @return
     */
    public List<Permissions> getAllPermissions();

    /**
     * 获取角色列表
     * @return
     */
    public List<Role> getAllRoles();

}
