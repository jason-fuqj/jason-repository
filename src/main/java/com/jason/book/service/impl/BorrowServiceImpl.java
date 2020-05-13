package com.jason.book.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.jason.book.mapper.BorrowHistoryMapper;
import com.jason.book.service.IBorrowService;
import com.jason.book.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO: 借还图书服务实现
 * <p>
 * Created by Jason.Fu on 2020/5/10.
 */
@Service
public class BorrowServiceImpl implements IBorrowService {

    @Autowired
    BorrowHistoryMapper borrowHistoryMapper;

    @Override
    public JSONObject borrowBook(JSONObject jsonObject) {
        int result = borrowHistoryMapper.borrowBook(jsonObject);
        JSONObject record = new JSONObject();
        record.put("result",result);
        return ResultUtil.successJson(record);
    }

    @Override
    public JSONObject returnBook(JSONObject jsonObject) {
        int result = borrowHistoryMapper.returnBook(jsonObject);
        JSONObject record = new JSONObject();
        record.put("result",result);
        return ResultUtil.successJson(record);
    }

    @Override
    public JSONObject selectBorrowHistoryByPage(JSONObject jsonObject) {
        ResultUtil.fillPageParam(jsonObject);
        int count = borrowHistoryMapper.getCount(jsonObject);
        List<JSONObject> list = borrowHistoryMapper.selectBorrowByPage(jsonObject);
        return ResultUtil.successPage(jsonObject,list,count);
    }
}
