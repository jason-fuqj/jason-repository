package com.jason.book.mapper;

import com.jason.book.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

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
     * @param record
     * @return
     */
    int addBook(Book record);

    /**
     * 按书籍id删除
     * @param bookId
     * @return
     */
    int deleteByPrimaryKey(Long bookId);

    /**
     * 更新书籍信息
     * @param record
     * @return
     */
    int updateByPrimaryKey(Book record);

    /**
     * 根据书目类别分页查询
     * @param categoryId 书目类别
     * @param pageNumber 当前页数
     * @param PageSize 每页显示数量
     * @return
     */
    List<Book> selectBookListByPage(@Param("categoryId") Long categoryId, @Param("pageNumber") int pageNumber, @Param("pageSize") int PageSize);

    /**
     * 根据书目类别查询总数
     * @param categoryId 书目类别
     * @return
     */
    int getCountByCategoryId(@Param("categoryId") Long categoryId);
}
