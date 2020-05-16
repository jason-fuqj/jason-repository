package com.jason.book.mapper;

import com.alibaba.fastjson.JSONObject;
import com.jason.book.domain.Permissions;
import com.jason.book.utils.One2Many;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * TODO:
 * <p>
 * Created by Jason.Fu on 2020/5/12.
 */
@Component
@Mapper
public interface PermissionMapper {

    One2Many getUserPermission(String userName);

    List<Permissions>  getAllPermission();

    List<Permissions>  getAllMenu();

    int deleteByPrimaryKey(Integer id);

    int updateByPrimaryKey(Map paramMap);

}
