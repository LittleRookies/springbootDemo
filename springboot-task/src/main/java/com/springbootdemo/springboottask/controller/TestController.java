package com.springbootdemo.springboottask.controller;

import com.springbootdemo.springboottask.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Little Rookies
 * @Date: 2018/11/12 16:13
 */
@RestController
public class TestController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/async")
    public String async() throws InterruptedException {
        taskService.test();
        return "任务已经开始了！";
    }

    @GetMapping("/mail")
    public String mail() {
        return "发送成功";
    }
}
