package com.springbootdemo.springbootjpa.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @Author: Little Rookies
 * @Date: 2018/11/8 09:41
 */
//使用JPA注解配置映射关系
@Entity(name = "person") //告诉JPA这是一个实体类（和数据表映射的类）
public class PersonEntity {
    private Integer id;
    private String firstName;
    private String name;
    private String sex;
    private Integer age;

    @Id //这是一个主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增主键
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "first_name")//这是和数据表对应的一个列
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonEntity that = (PersonEntity) o;
        return id.equals(that.id) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(name, that.name) &&
                Objects.equals(sex, that.sex) &&
                Objects.equals(age, that.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, name, sex, age);
    }
}
