package com.springbootdemo.springbootmybatis.controller;

import com.springbootdemo.springbootmybatis.bean.Person;
import com.springbootdemo.springbootmybatis.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Little Rookies
 * @Date: 2018/11/7 15:53
 */
@RestController
public class PersonController {
    @Autowired
    private PersonMapper personMapper;

    @GetMapping("/select")
    public List<Person> select(String name) {
        return personMapper.findByName(name);
    }

    @GetMapping("/insert")
    public Integer insert(Person person) {
        return personMapper.insert(person);
    }

    @GetMapping("/del")
    public Integer del(Integer id) {
        return personMapper.del(id);
    }

    @GetMapping("/update")
    public Integer update(Person person) {
        return personMapper.update(person);
    }

    @GetMapping("/selectNa")
    public List<Person> findName(String name) {
        return personMapper.findName(name);
    }

    @GetMapping("/insertPe")
    public void insertper(Person person) {
        personMapper.insertper(person);
    }
}
