package com.jason.book.mapper;

import com.alibaba.fastjson.JSONObject;
import com.jason.book.domain.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * TODO: 角色mapper
 * <p>
 * Created by Jason.Fu on 2020/5/12.
 */
@Component
@Mapper
public interface RoleMapper {

    List<Role> getRoles();

    int deleteByPrimaryKey(Integer roleId);

    int updateByPrimaryKey(Role role);

    int addRole(Role role);

}
