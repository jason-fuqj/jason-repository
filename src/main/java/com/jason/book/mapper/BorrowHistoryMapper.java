package com.jason.book.mapper;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * TODO: 借还mapper
 * <p>
 * Created by Jason.Fu on 2020/5/13.
 */
@Component
@Mapper
public interface BorrowHistoryMapper {

    int borrowBook(JSONObject jsonObject);

    int returnBook(JSONObject jsonObject);

    List<JSONObject> selectBorrowByPage(JSONObject jsonObject);

    int getCount(JSONObject jsonObject);

}
