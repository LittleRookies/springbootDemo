package com.springbootdemo.filterinterceptor.config;

import com.springbootdemo.filterinterceptor.filter.MyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 在springboot中配置自定义过滤器
 *
 * @Author: Little Rookies
 * @Date: 2018/11/8 11:07
 */
@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean<MyFilter> registFilter() {
        FilterRegistrationBean<MyFilter> registration = new FilterRegistrationBean<MyFilter>();
        registration.setFilter(new MyFilter());
//        指定url的匹配模式
        registration.addUrlPatterns("/*");
        registration.setName("MyFilter");
        registration.setOrder(1);
        return registration;
    }
}
