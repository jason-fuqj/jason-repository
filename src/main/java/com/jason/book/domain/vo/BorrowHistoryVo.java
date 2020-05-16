package com.jason.book.domain.vo;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * TODO:
 * <p>
 * Created by Jason.Fu on 2020/5/16.
 */
public class BorrowHistoryVo extends PageVo{
    // 主键id
    @ApiModelProperty(value = "主键id", name = "id")
    private Integer id;
    // 用户ID
    @ApiModelProperty(value = "用户ID", name = "userId", required = true)
    private Integer userId;
    // 图书ID
    @ApiModelProperty(value = "图书ID", name = "bookId", required = true)
    private Integer bookId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }
}
