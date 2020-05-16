package com.jason.book.controller;

import com.alibaba.fastjson.JSONObject;
import com.jason.book.domain.Book;
import com.jason.book.domain.vo.BookVo;
import com.jason.book.service.IBookService;
import com.jason.book.utils.JasonResult;
import com.jason.book.utils.PageDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO: 图书控制类
 * <p>
 * Created by Jason.Fu on 2020/5/12.
 */
@Api(value = "BookController",tags = "图书模块接口")
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    IBookService iBookService;

    @ApiOperation(value = "图书列表",notes = "分页查询图书接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNumber", value = "页数",defaultValue = "0", required = true ,dataType = "string"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示数量",defaultValue = "10", required = true ,dataType = "string")})
    // 表示用户必须拥有读取列表的权限
    @RequiresPermissions("book:list")
    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    public JasonResult getBookList(
            @RequestParam(name = "pageNumber") Integer pageNumber,
            @RequestParam(name = "pageSize") Integer pageSize
    ){
        BookVo bookVo = new BookVo();
        bookVo.setPageNumber(pageNumber);
        bookVo.setPageSize(pageSize);
        PageDto<Book> bookPageDto = iBookService.selectBookListByPage(bookVo);
        return JasonResult.success(bookPageDto);
    }

    @ApiOperation(value = "新增图书",notes = "新增图书信息接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "bookName", value = "书名", required = true ,dataType = "string"),
            @ApiImplicitParam(name = "author", value = "作者", required = true ,dataType = "string"),
            @ApiImplicitParam(name = "publisher", value = "出版社", required = true ,dataType = "string")
    })
    @RequiresPermissions("book:add")
    @PostMapping("/add")
    public JasonResult addBook(Book book){
        int result = iBookService.addBook(book);
        Map<String,Integer> map = new HashMap<>();
        map.put("result",result);
        return JasonResult.success(map);
    }

    @ApiOperation(value = "删除图书",notes = "删除图书接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "bookId", value = "图书id", required = true ,dataType = "string")})
    @RequiresPermissions("book:delete")
    @PostMapping("/delete")
    public JasonResult deleteBook( @RequestParam(name = "bookId") Integer bookId){
        int result = iBookService.deleteByPrimaryKey(bookId);
        Map<String,Integer> map = new HashMap<>();
        map.put("result",result);
        return JasonResult.success(map);
    }

    @ApiOperation(value = "更新图书",notes = "修改图书信息接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "bookId", value = "图书id", required = true ,dataType = "string")})
    @RequiresPermissions("book:update")
    @PostMapping("/update")
    public JasonResult updateBook(Book book){
        int result = iBookService.updateByPrimaryKey(book);
        Map<String,Integer> map = new HashMap<>();
        map.put("result",result);
        return JasonResult.success(map);

    }

}
