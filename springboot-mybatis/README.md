# springboot+druid+MyBatis

### 注解方式



1. 创建bean实体类

2. 创建MyBatis配置类（非必要步骤，可以不用创建）

   ```java
   package com.springbootdemo.springbootmybatis.config;
   
   import org.apache.ibatis.session.Configuration;
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
   
   ```

3. 创建mapper类。

   mapper类可以通过在类上面加上`@mapper`标注或者在启动类中使用`@MapperScan`扫包标注整个包下的类。  

### xml方式

1. 在`application.yml`中指定mybatis配置文件

   ```xml
   mybatis:
     # 指定全局配置文件位置
     config-location: classpath:mybatis/mybatis-config.xml
     # 指定sql映射文件位置
     mapper-locations: classpath:mybatis/mapper/*.xml
   ```

2. 将mapper类中的sql语句写入mapper.xml中。
