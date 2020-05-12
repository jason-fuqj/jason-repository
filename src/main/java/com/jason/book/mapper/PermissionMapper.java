package com.jason.book.mapper;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * TODO:
 * <p>
 * Created by Jason.Fu on 2020/5/12.
 */
@Component
@Mapper
public interface PermissionMapper {

    List<JSONObject> getPermissionsByPage(JSONObject jsonObject);

    int getCount(JSONObject jsonObject);

    int addPermission(JSONObject jsonObject);

    int deleteByPrimaryKey(JSONObject jsonObject);

    int updateByPrimaryKey(JSONObject jsonObject);

}
