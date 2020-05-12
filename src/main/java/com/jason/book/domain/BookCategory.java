package com.jason.book.domain;

/**
 * TODO: 书目实体类
 * <p>
 * Created by Jason.Fu on 2020/5/10.
 */
public class BookCategory {
    // 书目id
    private Integer cateId;
    // 书目名称
    private String cateName;

    public Integer getCateId() {
        return cateId;
    }

    public void setCateId(Integer cateId) {
        this.cateId = cateId;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }
}
