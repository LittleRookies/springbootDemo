package com.springbootdemo.springbootmybatis.config;

import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;

/**
 * 开启驼峰映射
 */
@org.springframework.context.annotation.Configuration
public class MyBatisConfig {

//    @Bean
//    public ConfigurationCustomizer configurationCustomizer() {
//        return new ConfigurationCustomizer() {
//
//            @Override
//            public void customize(Configuration configuration) {
//                configuration.setMapUnderscoreToCamelCase(true);
//            }
//        };
//    }

    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return configuration -> configuration.setMapUnderscoreToCamelCase(true);
    }
}
