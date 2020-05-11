package com.jason.book.domain;

/**
 * TODO: 书目实体类
 * <p>
 * Created by Jason.Fu on 2020/5/10.
 */
public class BookCategory {
    // 书目id
    private Long id;
    // 书目名称
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
