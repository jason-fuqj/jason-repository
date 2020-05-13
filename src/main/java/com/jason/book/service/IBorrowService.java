package com.jason.book.service;

import com.alibaba.fastjson.JSONObject;

/**
 * TODO: 借还图书服务接口
 * <p>
 * Created by Jason.Fu on 2020/5/10.
 */
public interface IBorrowService {

    /**
     * 借书
     * @param jsonObject
     * @return
     */
    public JSONObject borrowBook(JSONObject jsonObject);

    /**
     * 还书
     * @param jsonObject
     * @return
     */
    public JSONObject returnBook(JSONObject jsonObject);

    /**
     * 分页查询借还记录
     * @param jsonObject
     * @return
     */
    public JSONObject selectBorrowHistoryByPage(JSONObject jsonObject);

}
