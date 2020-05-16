package com.jason.book.mapper;

import com.alibaba.fastjson.JSONObject;
import com.jason.book.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * TODO:
 * <p>
 * Created by Jason.Fu on 2020/5/10.
 */
@Component
@Mapper
public interface BookMapper {

    /**
     * 添加书籍
     * @param book
     * @return
     */
    int addBook(Book book);

    /**
     * 按书籍id删除
     * @param bookId
     * @return
     */
    int deleteByPrimaryKey(Integer bookId);

    /**
     * 更新书籍信息
     * @param book
     * @return
     */
    int updateByPrimaryKey(Book book);

    /**
     * 分页查询图书
     * @param book
     * @return
     */
    List<Book> selectBookListByPage(Book book);

}
