package com.jason.book.service.impl;

import com.jason.book.constants.Constants;
import com.jason.book.domain.Permissions;
import com.jason.book.domain.Role;
import com.jason.book.domain.User;
import com.jason.book.domain.vo.UserVo;
import com.jason.book.mapper.PermissionMapper;
import com.jason.book.mapper.RoleMapper;
import com.jason.book.mapper.UserMapper;
import com.jason.book.service.IUserService;
import com.jason.book.utils.One2Many;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * TODO: 用户服务实现类
 * <p>
 * Created by Jason.Fu on 2020/5/10.
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    PermissionMapper permissionMapper;

    @Autowired
    RoleMapper roleMapper;

    @Override
    public User getUserByName(String username) {
        return userMapper.selectByName(username);
    }

    @Override
    @Transactional
    public int addUser(UserVo userVo) {
        // 获取用户名，用于生成盐
        String password = userVo.getPassword();
        //生成盐（需要存入数据库中）
        ByteSource salt = ByteSource.Util.bytes(userVo.getUserName());
        //将原始密码加盐（上面生成的盐），并且用md5算法加密三次，将最后结果存入数据库中
        String encryptedPwd = new Md5Hash(password,salt, Constants.HASH_ITERATIONS).toString();
        User user = new User();
        BeanUtils.copyProperties(userVo,user);
        user.setPassword(encryptedPwd);
        user.setPwdRandom(salt.toString());

        return userMapper.addUser(user);
    }

    @Override
    @Transactional
    public int deleteByPrimaryKey(Integer userId) {
        return userMapper.deleteByPrimaryKey(userId);
    }

    @Override
    @Transactional
    public int updateByPrimaryKey(UserVo userVo) {
        User user = new User();
        BeanUtils.copyProperties(userVo,user);
        return userMapper.updateByPrimaryKey(user);
    }

    @Override
    public One2Many getUserPermissions(String userName) {
        return permissionMapper.getUserPermission(userName);
    }

    @Override
    public List<Permissions> getAllPermissions() {
        return permissionMapper.getAllPermission();
    }

    @Override
    public List<Role>  getAllRoles() {
        return roleMapper.getRoles();
    }
}
