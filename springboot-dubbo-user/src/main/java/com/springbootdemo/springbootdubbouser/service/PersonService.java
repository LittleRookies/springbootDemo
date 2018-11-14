package com.springbootdemo.springbootdubbouser.service;

import com.alibaba.dubbo.config.annotation.Reference;


import com.springbootdemo.springbootdubboservice.entity.Person;
import com.springbootdemo.springbootdubboservice.service.SayService;
import org.springframework.stereotype.Service;


/**
 * @Author: Little Rookies
 * @Date: 2018/11/13 14:43
 */
@Service
public class PersonService {
    @Reference
    private SayService sayService;

    public String find() {
        return sayService.find();
    }

    public Person findone() {
        return sayService.findOne();
    }
}
