package com.springbootdemo.springboottask;

import com.springbootdemo.springboottask.service.TaskService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootTaskApplicationTests {
    @Autowired
    private TaskService taskService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void async() throws InterruptedException {
        System.out.println("任务开始！");
        taskService.test();
        System.out.println("任务已经开始了！");
    }

    @Test
    public void mail() throws Exception {
        taskService.mail();
        taskService.mail01();
    }

}
