package com.jason.book.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jason.book.domain.BorrowHistory;
import com.jason.book.domain.vo.BorrowHistoryVo;
import com.jason.book.domain.vo.UserVo;
import com.jason.book.mapper.BorrowHistoryMapper;
import com.jason.book.service.IBorrowService;
import com.jason.book.utils.PageDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Transactional
    public int borrowBook(BorrowHistoryVo borrowHistoryVo) {
        BorrowHistory borrowHistory = new BorrowHistory();
        BeanUtils.copyProperties(borrowHistoryVo,borrowHistory);
        return borrowHistoryMapper.borrowBook(borrowHistory);
    }

    @Override
    @Transactional
    public int returnBook(BorrowHistoryVo borrowHistoryVo) {
        BorrowHistory borrowHistory = new BorrowHistory();
        BeanUtils.copyProperties(borrowHistoryVo,borrowHistory);
        return borrowHistoryMapper.returnBook(borrowHistory);
    }

    @Override
    public PageDto<BorrowHistory> selectBorrowHistoryByPage(UserVo userVo) {
        PageHelper.startPage(userVo.getPageNumber(), userVo.getPageSize());
        Map paramMap = new HashMap();
        paramMap.put("userId",userVo.getUserId());
        List<BorrowHistory> list = borrowHistoryMapper.selectBorrowByPage(paramMap);
        PageInfo<BorrowHistory> info = new PageInfo<>(list);
        PageDto<BorrowHistory> response = new PageDto<>();
        response.setPageNumber(info.getPageNum());
        response.setPageSize(info.getSize());
        response.setTotal(info.getTotal());
        response.setResult(list);
        return response;
    }
}
