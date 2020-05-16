package com.jason.book.utils;

import java.util.List;

/**
 * TODO: 分页数据封装
 * <p>
 * Created by Jason.Fu on 2020/5/16.
 */
public class PageDto<T> {

    private Integer pageSize = 10;

    private Integer pageNumber = 0;

    private Long total = 0L;

    private List<T> result;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }
}
