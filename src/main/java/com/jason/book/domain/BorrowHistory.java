package com.jason.book.domain;

import java.util.Date;

/**
 * TODO: 用户借阅历史
 * <p>
 * Created by Jason.Fu on 2020/5/9.
 */
public class BorrowHistory {
    // 主键id
    private Long id;
    // 用户ID
    private Long userId;
    // 图书ID
    private Long bookId;
    // 借书时间
    private Date bDate;
    // 还书时间
    private Date rDate;
    // 借还状态：0-已归还，1-未归还
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

        public Long getId() {
        return id;
    }

        public void setId(Long id) {
        this.id = id;
    }

        public Long getUserId() {
        return userId;
    }

        public void setUserId(Long userId) {
        this.userId = userId;
    }

        public Long getBookId() {
        return bookId;
    }

        public void setBookId(Long bookId) {
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
