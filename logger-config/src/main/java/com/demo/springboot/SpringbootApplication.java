package com.demo.springboot;

import com.demo.springboot.util.LoggerUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
        LoggerUtil demoUtil = new LoggerUtil();
        demoUtil.demo();
    }
}
