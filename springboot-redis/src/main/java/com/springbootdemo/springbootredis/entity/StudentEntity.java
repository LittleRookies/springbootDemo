package com.springbootdemo.springbootredis.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @Author: Little Rookies
 * @Date: 2018/11/8 17:20
 */
@Entity(name = "student")
public class StudentEntity {
    private Integer id;
    private String name;
    private Integer age;
    private Integer schoolNumber;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增主键
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
    @Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Basic
    @Column(name = "school_number")
    public Integer getSchoolNumber() {
        return schoolNumber;
    }

    public void setSchoolNumber(Integer schoolNumber) {
        this.schoolNumber = schoolNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentEntity that = (StudentEntity) o;
        return id.equals(that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(age, that.age) &&
                Objects.equals(schoolNumber, that.schoolNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, schoolNumber);
    }
}
