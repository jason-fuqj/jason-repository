package com.jason.book.service;

import com.jason.book.domain.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * TODO:
 * <p>
 * Created by Jason.Fu on 2020/5/10.
 */
public interface IBookService {

    public int addBook(Book book);

    public int deleteByPrimaryKey(Long bookId);

    public int updateByPrimaryKey(Book book);

    public List<Book> selectBookListByPage(Long categoryId,int pageNumber,int PageSize);

    public int getCountByCategoryId(Long categoryId);

}
