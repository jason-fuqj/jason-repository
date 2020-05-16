package com.jason.book.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jason.book.domain.Book;
import com.jason.book.domain.vo.BookVo;
import com.jason.book.mapper.BookMapper;
import com.jason.book.service.IBookService;
import com.jason.book.utils.PageDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * TODO: 图书服务实现类
 * <p>
 * Created by Jason.Fu on 2020/5/10.
 */
@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    BookMapper bookMapper;

    @Override
    @Transactional
    public int addBook(Book book) {
        return bookMapper.addBook(book);
    }

    @Override
    @Transactional
    public int deleteByPrimaryKey(Integer bookId) {
        return bookMapper.deleteByPrimaryKey(bookId);
    }

    @Override
    @Transactional
    public int updateByPrimaryKey(Book book) {
        return bookMapper.updateByPrimaryKey(book);
    }

    @Override
    public PageDto<Book> selectBookListByPage(BookVo bookVo) {

        PageHelper.startPage(bookVo.getPageNumber(), bookVo.getPageSize());
        Book book = new Book();
        BeanUtils.copyProperties(bookVo,book);
        List<Book> list = bookMapper.selectBookListByPage(book);

        PageInfo<Book> info = new PageInfo<>(list);
        PageDto<Book> response = new PageDto<>();
        response.setPageNumber(info.getPageNum());
        response.setPageSize(info.getSize());
        response.setTotal(info.getTotal());
        response.setResult(list);
        return response;
    }

}
