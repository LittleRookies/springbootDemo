# springboot配置文件

## SpringBoot使用一个全局的配置文件，配置文件名是固定的；

•application.properties

•application.yml

## yml格式

•key:value

•map 对象方式

•list 字典方式

## **注入**

•@ConfigurationProperties

•@Value

​                         @Value获取值和@ConfigurationProperties获取值比较

|                      | @ConfigurationProperties | @Value     |
| -------------------- | ------------------------ | ---------- |
| 功能                 | 批量注入配置文件中的属性 | 一个个指定 |
| 松散绑定（松散语法） | 支持                     | 不支持     |
| SpEL                 | 不支持                   | 支持       |
| JSR303数据校验       | 支持                     | 不支持     |
| 复杂类型封装         | 支持                     | 不支持     |

## **指定环境配置**

yml可以用“---”进行多模块环境变量配置

```yaml
#指定配置环境
spring:
  profiles:
    active: dev
---
server:
  port: 8091
spring:
  profiles: test
---
server:
  port: 8092
spring:
  profiles: dev
```

激活指定profile

```shell
1、在配置文件中指定  spring.profiles.active=dev

2、命令行：

	java -jar spring-boot-02-config-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev；

	可以直接在测试的时候，配置传入命令行参数

3、虚拟机参数；

	-Dspring.profiles.active=dev
```