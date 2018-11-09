package com.springbootdemo.springbootredis.controller;

import com.springbootdemo.springbootredis.entity.StudentEntity;
import com.springbootdemo.springbootredis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Little Rookies
 * @Date: 2018/11/8 17:22
 */
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/stufind")
    public StudentEntity stufind(Integer id) {
        return studentService.find(id);
    }
}
