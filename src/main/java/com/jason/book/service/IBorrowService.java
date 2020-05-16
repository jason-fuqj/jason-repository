package com.jason.book.service;

import com.jason.book.domain.BorrowHistory;
import com.jason.book.domain.vo.BorrowHistoryVo;
import com.jason.book.domain.vo.UserVo;
import com.jason.book.utils.PageDto;

import java.util.Map;

/**
 * TODO: 借还图书服务接口
 * <p>
 * Created by Jason.Fu on 2020/5/10.
 */
public interface IBorrowService {

    /**
     * 用户借书
     * @param borrowHistory
     * @return
     */
    public int borrowBook(BorrowHistoryVo borrowHistory);

    /**
     * 用户还书
     * @param borrowHistory
     * @return
     */
    public int returnBook(BorrowHistoryVo borrowHistory);

    /**
     * 分页查询用户借还记录
     * @param userVo
     * @return
     */
    public PageDto<BorrowHistory> selectBorrowHistoryByPage(UserVo userVo);

}
