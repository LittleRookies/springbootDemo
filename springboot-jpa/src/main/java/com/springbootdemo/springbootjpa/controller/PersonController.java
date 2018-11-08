package com.springbootdemo.springbootjpa.controller;

import com.springbootdemo.springbootjpa.entity.PersonEntity;
import com.springbootdemo.springbootjpa.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Little Rookies
 * @Date: 2018/11/8 09:50
 */
@RestController
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    @GetMapping(name = "/insert")
    public void save(PersonEntity personEntity) {
        personRepository.save(personEntity);
    }

    @GetMapping("/find")
    public List<PersonEntity> find(String name) {
        return personRepository.findAllByName(name);
    }

    @GetMapping("/findByPage")
    public List<PersonEntity> findByPage(Integer page, String name) {
        Pageable pageable = PageRequest.of(page - 1, 15);//page-1为页码（从0页开始），15为每页数量
        Page<PersonEntity> all = personRepository.findByName(name, pageable);
        return all.getContent();
    }
}
