package com.springbootdemo.springbootsolr.entity;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.io.Serializable;

/**
 * @Author: Little Rookies
 * @Date: 2018/11/12 11:17
 */
@SolrDocument(solrCoreName = "demo")
public class Book implements Serializable {
    @Id
    private String id;
    @Field()
    private String bookName;
    @Field()
    private String author;
    @Field
    private Integer piece;
    @Field()
    private Integer number;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getPiece() {
        return piece;
    }

    public void setPiece(Integer piece) {
        this.piece = piece;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":\"")
                .append(id).append('\"');
        sb.append(",\"bookName\":\"")
                .append(bookName).append('\"');
        sb.append(",\"author\":\"")
                .append(author).append('\"');
        sb.append(",\"piece\":")
                .append(piece);
        sb.append(",\"number\":")
                .append(number);
        sb.append('}');
        return sb.toString();
    }
}
