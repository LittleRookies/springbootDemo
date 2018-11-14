package com.springbootdemo.springbootdubboservice.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author: Little Rookies
 * @Date: 2018/11/13 14:28
 */
@Entity(name = "person")
public class Person implements Serializable {
    private Integer id;
    private String name;
    private String sex;
    private Integer age;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增主键
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
