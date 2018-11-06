package com.springbootdemo.configurationfile.controller;


import com.springbootdemo.configurationfile.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Little Rookies
 * @Date: 2018/11/6 15:24
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Value("${person.last-name}")
    private String name;

    @Autowired
    private Person person;

    @GetMapping(value = "/name")
    public String name() {
        return name;
    }

    @GetMapping(value = "/bean")
    public Person person() {
        return person;
    }
}
