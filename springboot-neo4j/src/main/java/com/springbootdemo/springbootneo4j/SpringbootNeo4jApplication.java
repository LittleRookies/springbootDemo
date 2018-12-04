package com.springbootdemo.springbootneo4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableNeo4jRepositories
@EnableTransactionManagement // 激活SDN隐式事务
public class SpringbootNeo4jApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootNeo4jApplication.class, args);
    }
}
//@EnableNeo4jRepositories：Neo4j扫描Repositories所在包，理解为mybatis扫描mapper包
//@EnableTransactionManagement：Neo4j完整的支持ACID，所以此处开启事务功能。
