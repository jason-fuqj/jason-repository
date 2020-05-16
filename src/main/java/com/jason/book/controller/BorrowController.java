package com.jason.book.controller;

import com.jason.book.domain.BorrowHistory;
import com.jason.book.domain.vo.BorrowHistoryVo;
import com.jason.book.domain.vo.UserVo;
import com.jason.book.service.IBorrowService;
import com.jason.book.service.IUserService;
import com.jason.book.utils.JasonResult;
import com.jason.book.utils.PageDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO: 借还书管理控制类
 * <p>
 * Created by Jason.Fu on 2020/5/16.
 */
@Api(value = "BorrowController",tags = "借还模块接口")
@RestController
@RequestMapping("/borrow")
public class BorrowController {

    @Autowired
    IBorrowService iBorrowService;

    @ApiOperation(value = "用户借书",notes = "用户借书接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true ,dataType = "string"),
            @ApiImplicitParam(name = "bookId", value = "图书ID", required = true ,dataType = "string")
    })
    @RequiresPermissions("borrow:add")
    @PostMapping("/borrowBook")
    public JasonResult borrowBook(
            @RequestParam(name = "userId") Integer userId,
            @RequestParam(name = "bookId") Integer bookId
    ) {
        BorrowHistoryVo borrowHistoryVo = new BorrowHistoryVo();
        borrowHistoryVo.setUserId(userId);
        borrowHistoryVo.setBookId(bookId);
        int result = iBorrowService.borrowBook(borrowHistoryVo);
        Map<String,Integer> map = new HashMap<>();
        map.put("result",result);
        return JasonResult.success(map);
    }

    @ApiOperation(value = "用户还书",notes = "用户还书接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true ,dataType = "string"),
            @ApiImplicitParam(name = "bookId", value = "图书ID", required = true ,dataType = "string")
    })
    @RequiresPermissions("borrow:update")
    @PostMapping("/returnBook")
    public JasonResult returnBook(
            @RequestParam(name = "userId") Integer userId,
            @RequestParam(name = "bookId") Integer bookId
    ) {
        BorrowHistoryVo borrowHistoryVo = new BorrowHistoryVo();
        borrowHistoryVo.setUserId(userId);
        borrowHistoryVo.setBookId(bookId);
        int result = iBorrowService.returnBook(borrowHistoryVo);
        Map<String,Integer> map = new HashMap<>();
        map.put("result",result);
        return JasonResult.success(map);
    }

    @ApiOperation(value = "用户借还记录列表",notes = "查询用户借还记录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true ,dataType = "string"),
            @ApiImplicitParam(name = "pageNumber", value = "页数",defaultValue = "0", required = true ,dataType = "string"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示数量",defaultValue = "10", required = true ,dataType = "string")
    })
    @RequiresPermissions("borrow:list")
    @GetMapping("/getBorrowList")
    public JasonResult getBorrowList(
            @RequestParam(name = "pageNumber") Integer pageNumber,
             @RequestParam(name = "pageSize") Integer pageSize,
             @RequestParam(name = "userId") Integer userId
    ){
        UserVo userVo = new UserVo();
        userVo.setUserId(userId);
        userVo.setPageNumber(pageNumber);
        userVo.setPageSize(pageSize);
        PageDto<BorrowHistory> list = iBorrowService.selectBorrowHistoryByPage(userVo);
        return JasonResult.success(list);
    }

}
