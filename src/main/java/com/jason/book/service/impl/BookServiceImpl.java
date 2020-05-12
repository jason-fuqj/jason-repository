package com.jason.book.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.jason.book.domain.Book;
import com.jason.book.mapper.BookMapper;
import com.jason.book.service.IBookService;
import com.jason.book.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO: 图书服务实现类
 * <p>
 * Created by Jason.Fu on 2020/5/10.
 */
@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    BookMapper bookMapper;

    @Override
    public JSONObject addBook(JSONObject jsonObject) {
        int result =  bookMapper.addBook(jsonObject);
        JSONObject record = new JSONObject();
        record.put("result",result);
        return ResultUtil.successJson(record);
    }

    @Override
    public JSONObject deleteByPrimaryKey(JSONObject jsonObject) {
        int result = bookMapper.deleteByPrimaryKey(jsonObject);
        JSONObject record = new JSONObject();
        record.put("result",result);
        return ResultUtil.successJson(record);
    }

    @Override
    public JSONObject updateByPrimaryKey(JSONObject jsonObject) {
        int result = bookMapper.updateByPrimaryKey(jsonObject);
        JSONObject record = new JSONObject();
        record.put("result",result);
        return ResultUtil.successJson(record);
    }

    @Override
    public JSONObject selectBookListByPage(JSONObject jsonObject) {
        ResultUtil.fillPageParam(jsonObject);
        int count = bookMapper.getCount(jsonObject);
        List<JSONObject> list = bookMapper.selectBookListByPage(jsonObject);
        return ResultUtil.successPage(jsonObject,list,count);
    }

    @Override
    public int getCount(JSONObject jsonObject) {
        return bookMapper.getCount(jsonObject);
    }
}
