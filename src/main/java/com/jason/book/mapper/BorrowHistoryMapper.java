package com.jason.book.mapper;

import com.alibaba.fastjson.JSONObject;
import com.jason.book.domain.BorrowHistory;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * TODO: 借还mapper
 * <p>
 * Created by Jason.Fu on 2020/5/13.
 */
@Component
@Mapper
public interface BorrowHistoryMapper {

    int borrowBook(BorrowHistory borrowHistory);

    int returnBook(BorrowHistory borrowHistory);

    List<BorrowHistory> selectBorrowByPage(Map paramMap);

    BorrowHistory getBorrowHistory(Map paramMap);

}
