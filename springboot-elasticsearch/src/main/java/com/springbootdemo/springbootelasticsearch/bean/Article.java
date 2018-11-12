package com.springbootdemo.springbootelasticsearch.bean;

import io.searchbox.annotations.JestId;

/**
 * 适用于 jest
 * @Author: Little Rookies
 * @Date: 2018/11/12 11:17
 */
public class Article {

    @JestId
    private Integer id;
    private String author;
    private String title;
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
