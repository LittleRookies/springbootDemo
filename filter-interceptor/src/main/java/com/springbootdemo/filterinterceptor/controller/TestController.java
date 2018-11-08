package com.springbootdemo.filterinterceptor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Little Rookies
 * @Date: 2018/11/8 13:51
 */
@RestController
public class TestController {
    @GetMapping("/test")
    public String test() {
        System.out.println("这里是Controller层！");
        return "测试测试！";
    }
}
