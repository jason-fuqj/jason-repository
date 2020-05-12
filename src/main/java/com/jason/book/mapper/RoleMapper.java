package com.jason.book.mapper;

import com.jason.book.domain.Role;

import java.util.List;

/**
 * TODO: 角色mapper
 * <p>
 * Created by Jason.Fu on 2020/5/12.
 */
public interface RoleMapper {

    List<Role> getRoles(Long userId);
}
