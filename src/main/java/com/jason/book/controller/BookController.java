package com.jason.book.controller;

import com.alibaba.fastjson.JSONObject;
import com.jason.book.domain.Book;
import com.jason.book.service.IBookService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO:
 * <p>
 * Created by Jason.Fu on 2020/5/12.
 */
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    IBookService iBookService;

    // 表示用户必须拥有读取列表的权限
//    @RequiresPermissions("book:list")
    @RequestMapping("/getList")
    public JSONObject getBookList(Book book){
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(book);
        return iBookService.selectBookListByPage(jsonObject);
    }
}
