package com.springbootdemo.filterinterceptor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
//@ServletComponentScan("com.springbootdemo.filterinterceptor.filter")
public class FilterInterceptorApplication {

    public static void main(String[] args) {
        SpringApplication.run(FilterInterceptorApplication.class, args);
    }
}
