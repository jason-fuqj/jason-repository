package com.jason.book.service.impl;

import com.jason.book.domain.Book;
import com.jason.book.mapper.BookMapper;
import com.jason.book.service.IBookService;
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
    public int addBook(Book book) {
        return bookMapper.addBook(book);
    }

    @Override
    public int deleteByPrimaryKey(Long bookId) {
        return bookMapper.deleteByPrimaryKey(bookId);
    }

    @Override
    public int updateByPrimaryKey(Book book) {
        return bookMapper.updateByPrimaryKey(book);
    }

    @Override
    public List<Book> selectBookListByPage(Long categoryId, int pageNumber, int PageSize) {
        return bookMapper.selectBookListByPage(categoryId,pageNumber,PageSize);
    }

    @Override
    public int getCountByCategoryId(Long categoryId) {
        return bookMapper.getCountByCategoryId(categoryId);
    }
}
