package com.jason.book.domain;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 * TODO:图书实体类
 * <p>
 * Created by Jason.Fu on 2020/5/9.
 */
public class Book implements Serializable {
    // 编号
    @ApiModelProperty(value = "图书ID", name = "bookId")
    private Integer bookId;
    // 作者
    @ApiModelProperty(value = "作者", name = "author")
    private String author;
    // 书名
    @ApiModelProperty(value = "图书名称", name = "bookName")
    private String bookName;
    // 出版社
    @ApiModelProperty(value = "出版社", name = "publisher")
    private String publisher;
    // 入库时间
    @ApiModelProperty(value = "入库时间", name = "createDate")
    private Date createDate;
    // 状态：0-借出，1-在架
    @ApiModelProperty(value = "状态", name = "status")
    private Integer status;
    // 图书类别id
    @ApiModelProperty(value = "书目id", name = "categoryId")
    private Integer categoryId;
    // 价格
    @ApiModelProperty(value = "价格", name = "price")
    private BigDecimal price;
    // 简介
    @ApiModelProperty(value = "图书简介", name = "description")
    private String description;

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", author='" + author + '\'' +
                ", bookName='" + bookName + '\'' +
                ", publisher='" + publisher + '\'' +
                ", createDate=" + createDate +
                ", status=" + status +
                ", categoryId=" + categoryId +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
