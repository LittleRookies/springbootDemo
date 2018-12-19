package com.springbootdemo.springbootRedisPlus.bean;

/**
 * @author Little Rookies
 * @create 2018-12-19 10:28
 */
public class RedisBean {
    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "RedisBean{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
