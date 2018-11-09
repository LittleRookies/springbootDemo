package com.springbootdemo.springbootredis.config;


import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 自定义keyGenerator生成器
 *
 * @Author: Little Rookies
 * @Date: 2018/11/9 09:37
 */
@Configuration
public class MyCacheConfig {
    @Bean("mykeyGenerator")
    public KeyGenerator keyGenerator() {
//        设置redis的key格式
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                return method.getName() + "[" + Arrays.asList(params).toString() + "]";
            }
        };
    }
}
