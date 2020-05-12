package com.jason.book.service;

import com.alibaba.fastjson.JSONObject;
import com.jason.book.domain.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * TODO: 图书服务接口
 * <p>
 * Created by Jason.Fu on 2020/5/10.
 */
public interface IBookService {

    public JSONObject addBook(JSONObject jsonObject);

    public JSONObject deleteByPrimaryKey(JSONObject jsonObject);

    public JSONObject updateByPrimaryKey(JSONObject jsonObject);

    public JSONObject selectBookListByPage(JSONObject jsonObject);

    public int getCount(JSONObject jsonObject);

}
