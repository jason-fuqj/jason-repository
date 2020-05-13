package com.jason.book.domain;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * TODO: 用户借还历史记录
 * <p>
 * Created by Jason.Fu on 2020/5/10.
 */
public class BorrowHistory {
    // 主键id
    @ApiModelProperty(value = "主键id", name = "id")
    private Integer id;
    // 用户ID
    @ApiModelProperty(value = "用户ID", name = "userId")
    private Integer userId;
    // 图书ID
    @ApiModelProperty(value = "图书ID", name = "bookId")
    private Integer bookId;
    // 借书时间
    @ApiModelProperty(value = "借书时间", name = "bDate")
    private Date bDate;
    // 还书时间
    @ApiModelProperty(value = "还书时间", name = "rDate")
    private Date rDate;
    // 借还状态：0-已归还，1-未归还
    @ApiModelProperty(value = "借还状态：0-已归还，1-未归还", name = "status")
    private Integer status;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userId=" + userId +
                ", bookId=" + bookId +
                ", bDate=" + bDate +
                ", rDate=" + rDate +
                ", status=" + status +
                '}';
    }

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

    public Date getbDate() {
        return bDate;
    }

        public void setbDate(Date bDate) {
        this.bDate = bDate;
    }

        public Date getrDate() {
        return rDate;
    }

        public void setrDate(Date rDate) {
        this.rDate = rDate;
    }

        public Integer getStatus() {
        return status;
    }

        public void setStatus(Integer status) {
        this.status = status;
    }
}
