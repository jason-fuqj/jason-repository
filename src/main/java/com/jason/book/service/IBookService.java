package com.jason.book.service;

import com.alibaba.fastjson.JSONObject;
import com.jason.book.domain.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * TODO:
 * <p>
 * Created by Jason.Fu on 2020/5/10.
 */
public interface IBookService {

    public int addBook(JSONObject jsonObject);

    public int deleteByPrimaryKey(Long bookId);

    public int updateByPrimaryKey(JSONObject jsonObject);

    public JSONObject selectBookListByPage(JSONObject jsonObject);

    public int getCountByCategoryId(JSONObject jsonObject);

}
