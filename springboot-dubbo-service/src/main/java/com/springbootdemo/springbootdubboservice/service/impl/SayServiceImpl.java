package com.springbootdemo.springbootdubboservice.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.springbootdemo.springbootdubboservice.entity.Person;
import com.springbootdemo.springbootdubboservice.repository.PersonRepository;
import com.springbootdemo.springbootdubboservice.service.SayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * @Author: Little Rookies
 * @Date: 2018/11/13 14:01
 */
@Component
@Service
public class SayServiceImpl implements SayService {
    @Autowired
    private PersonRepository personRepository;

    @Override
    public String find() {
        return personRepository.findFirstById(1).getName();
    }

    @Override
    public Person findOne() {
        return personRepository.findFirstById(1);
    }
}
