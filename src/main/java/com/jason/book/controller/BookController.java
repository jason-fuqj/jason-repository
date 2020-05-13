package com.jason.book.controller;

import com.alibaba.fastjson.JSONObject;
import com.jason.book.constants.ErrorCodeEnum;
import com.jason.book.domain.Book;
import com.jason.book.service.IBookService;
import com.jason.book.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO: 图书控制类
 * <p>
 * Created by Jason.Fu on 2020/5/12.
 */
@Api(value = "BookController",tags = "图书模块")
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    IBookService iBookService;

    @ApiOperation(value = "图书列表",notes = "分页查询图书接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "bookName", value = "书名", required = false ,dataType = "string"),
            @ApiImplicitParam(name = "categoryId", value = "所属数目id", required = false ,dataType = "string"),
            @ApiImplicitParam(name = "author", value = "作者", required = false ,dataType = "string")})
    // 表示用户必须拥有读取列表的权限
    @RequiresPermissions("book:list")
    @GetMapping("/getList")
    public JSONObject getBookList(Book book){
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(book);
        return iBookService.selectBookListByPage(jsonObject);
    }

    @ApiOperation(value = "新增图书",notes = "新增图书信息接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "bookName", value = "书名", required = true ,dataType = "string"),
            @ApiImplicitParam(name = "author", value = "作者", required = true ,dataType = "string"),
            @ApiImplicitParam(name = "categoryId", value = "所属书目", required = false ,dataType = "string"),
            @ApiImplicitParam(name = "price", value = "价格", required = false ,dataType = "string"),
            @ApiImplicitParam(name = "description", value = "简介", required = false ,dataType = "string"),
            @ApiImplicitParam(name = "publisher", value = "出版社", required = false ,dataType = "string")})
    @RequiresPermissions("book:add")
    @PostMapping("/add")
    public JSONObject addBook(Book book){
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(book);
        return iBookService.addBook(jsonObject);
    }

    @ApiOperation(value = "删除图书",notes = "删除图书接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "bookId", value = "图书id", required = true ,dataType = "string")})
    @RequiresPermissions("book:delete")
    @PostMapping("/delete")
    public JSONObject deleteBook(Book book){
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(book);
        return iBookService.deleteByPrimaryKey(jsonObject);
    }

    @ApiOperation(value = "更新图书",notes = "修改图书信息接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "bookId", value = "图书id", required = true ,dataType = "string"),
            @ApiImplicitParam(name = "bookName", value = "书名", required = false ,dataType = "string"),
            @ApiImplicitParam(name = "author", value = "作者", required = false ,dataType = "string"),
            @ApiImplicitParam(name = "categoryId", value = "所属书目", required = false ,dataType = "string"),
            @ApiImplicitParam(name = "price", value = "价格", required = false ,dataType = "string"),
            @ApiImplicitParam(name = "description", value = "简介", required = false ,dataType = "string"),
            @ApiImplicitParam(name = "publisher", value = "出版社", required = false ,dataType = "string")})
    @RequiresPermissions("book:update")
    @PostMapping("/update")
    public JSONObject updateBook(Book book){
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(book);
        return iBookService.updateByPrimaryKey(jsonObject);
    }

}
