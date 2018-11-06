package com.springbootdemo.configurationfile.bean;

/**
 * @Author: Little Rookies
 * @Date: 2018/11/6 15:21
 */
public class Dog {
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
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"name\":\"")
                .append(name).append('\"');
        sb.append(",\"age\":\"")
                .append(age).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
