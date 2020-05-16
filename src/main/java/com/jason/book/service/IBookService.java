package com.jason.book.service;

import com.alibaba.fastjson.JSONObject;
import com.jason.book.domain.Book;
import com.jason.book.domain.vo.BookVo;
import com.jason.book.utils.PageDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * TODO: 图书服务接口
 * <p>
 * Created by Jason.Fu on 2020/5/10.
 */
public interface IBookService {

    /**
     * 添加图书
     * @param book
     * @return
     */
    public int addBook(Book book);

    /**
     * 删除图书
     * @param bookId
     * @return
     */
    public int deleteByPrimaryKey(Integer bookId);

    /**
     * 更新图书信息
     * @param book
     * @return
     */
    public int updateByPrimaryKey(Book book);

    /**
     * 分页查询图书信息
     * @param bookVo
     * @return
     */
    public PageDto<Book> selectBookListByPage(BookVo bookVo);

}
