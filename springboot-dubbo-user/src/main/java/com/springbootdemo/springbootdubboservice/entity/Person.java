package com.springbootdemo.springbootdubboservice.entity;

import java.io.Serializable;

/**
 * @Author: Little Rookies
 * @Date: 2018/11/13 14:28
 */
public class Person implements Serializable {
    private Integer id;
    private String name;
    private String sex;
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
