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
 * TODO: 书籍服务实现类
 * <p>
 * Created by Jason.Fu on 2020/5/10.
 */
@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    BookMapper bookMapper;

    @Override
    public int addBook(JSONObject jsonObject) {
        return bookMapper.addBook(jsonObject);
    }

    @Override
    public int deleteByPrimaryKey(Long bookId) {
        return bookMapper.deleteByPrimaryKey(bookId);
    }

    @Override
    public int updateByPrimaryKey(JSONObject jsonObject) {
        return bookMapper.updateByPrimaryKey(jsonObject);
    }

    @Override
    public JSONObject selectBookListByPage(JSONObject jsonObject) {
        ResultUtil.fillPageParam(jsonObject);
        int count = bookMapper.getCountByCategoryId(jsonObject);
        List<JSONObject> list = bookMapper.selectBookListByPage(jsonObject);
        return ResultUtil.successPage(jsonObject,list,count);
    }

    @Override
    public int getCountByCategoryId(JSONObject jsonObject) {
        return bookMapper.getCountByCategoryId(jsonObject);
    }
}
