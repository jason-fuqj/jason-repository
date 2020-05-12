package com.jason.book.mapper;

import com.alibaba.fastjson.JSONObject;
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
     * @param bookObject
     * @return
     */
    int addBook(JSONObject bookObject);

    /**
     * 按书籍id删除
     * @param bookId
     * @return
     */
    int deleteByPrimaryKey(Long bookId);

    /**
     * 更新书籍信息
     * @param bookObject
     * @return
     */
    int updateByPrimaryKey(JSONObject bookObject);

    /**
     * 分页查询图书
     * @param jsonObject
     * @return
     */
    List<JSONObject> selectBookListByPage(JSONObject jsonObject);

    /**
     * 查询书籍总数
     * @param jsonObject
     * @return
     */
    int getCountByCategoryId(JSONObject jsonObject);
}
