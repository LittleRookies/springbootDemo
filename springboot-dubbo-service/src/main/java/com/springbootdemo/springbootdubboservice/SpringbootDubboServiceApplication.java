package com.springbootdemo.springbootdubboservice;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo(scanBasePackages = "com.springbootdemo.springbootdubboservice.service")
public class SpringbootDubboServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDubboServiceApplication.class, args);
    }
}
