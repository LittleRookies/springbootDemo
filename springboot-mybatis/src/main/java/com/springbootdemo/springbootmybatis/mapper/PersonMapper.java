package com.springbootdemo.springbootmybatis.mapper;

import com.springbootdemo.springbootmybatis.bean.Person;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author: Little Rookies
 * @Date: 2018/11/7 15:43
 */
//@Mapper
public interface PersonMapper {
    @Select("select * from person where name=#{name}")
    List<Person> findByName(String name);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into person(name,sex,age,first_name) value(#{name},#{sex},#{age},#{firstName})")
    int insert(Person person);

    @Delete("DELETE FROM `person` WHERE id=#{id}")
    int del(Integer id);

    @Update("update person set first_name=#{firstName} where id=#{id}")
    int update(Person person);

    List<Person> findName(String name);

    void insertper(Person person);
}
