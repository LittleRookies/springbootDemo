package com.springbootdemo.springbootdubbouser.controller;

import com.springbootdemo.springbootdubboservice.entity.Person;
import com.springbootdemo.springbootdubbouser.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author: Little Rookies
 * @Date: 2018/11/13 14:44
 */
@RestController
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping("/find")
    public Person find() {
        return personService.findone();
    }
}
