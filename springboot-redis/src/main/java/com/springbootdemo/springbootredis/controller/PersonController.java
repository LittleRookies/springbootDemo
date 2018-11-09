package com.springbootdemo.springbootredis.controller;

import com.springbootdemo.springbootredis.entity.PersonEntity;
import com.springbootdemo.springbootredis.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author: Little Rookies
 * @Date: 2018/11/8 17:18
 */
@RestController
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping("/find")
    public PersonEntity find(Integer id) {
        return personService.find(id);
    }

    @GetMapping("/save")
    public PersonEntity save(PersonEntity personEntity) {
        return personService.save(personEntity);
    }

    @GetMapping("/del")
    public void del(Integer id) {
        personService.del(id);
    }
}
