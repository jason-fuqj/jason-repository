package com.jason.book.domain.vo;

import io.swagger.annotations.ApiModelProperty;

/**
 * TODO:
 * <p>
 * Created by Jason.Fu on 2020/5/16.
 */
public class PageVo {

    @ApiModelProperty(value = "每页显示数量", name = "pageSize")
    private Integer pageSize;

    @ApiModelProperty(value = "当前页数", name = "pageNumber")
    private Integer pageNumber;

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
}
