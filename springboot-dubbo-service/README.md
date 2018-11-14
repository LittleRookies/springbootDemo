# springboot+jpa+dubbo 服务端

#### zookeeper

**使用dubbo前需要先启动zookeeper，我是在docker中启动的zookeeper。**

```shell
docker search zookeeper
docker pull zookeeper
docker run -d --name zookeeper -p 2181:2181 zookeeper
```



####springboot整合dubbo

1. pom.xml(不需要web服务。)

   ```xml
           <dependency>
               <groupId>com.alibaba.boot</groupId>
               <artifactId>dubbo-spring-boot-starter</artifactId>
               <version>0.2.0</version>
           </dependency>
   ```

2. 配置文件

   ```properties
   #dubbo配置文件
   dubbo.application.name=springboot-dubbo-service
   dubbo.registry.address=zookeeper://***.***.***.***:2181
   #duird数据池配置
   spring.datasource.url=jdbc:mysql://center:3306/demo?useUnicode=true&connectionCollation=utf8_general_ci&characterSetResults=utf8&zeroDateTimeBehavior=convertToNull
   spring.datasource.username=root
   spring.datasource.password=123456
   spring.datasource.druid.filters=stat,wall
   spring.datasource.druid.initial-size=5
   spring.datasource.druid.max-active=30
   spring.datasource.druid.max-pool-prepared-statement-per-connection-size=50
   spring.datasource.druid.max-wait=60000
   spring.datasource.druid.min-evictable-idle-time-millis=300000
   spring.datasource.druid.min-idle=5
   spring.datasource.druid.pool-prepared-statements=true
   spring.datasource.druid.test-on-borrow=false
   spring.datasource.druid.test-on-return=false
   spring.datasource.druid.test-while-idle=true
   spring.datasource.druid.time-between-eviction-runs-millis=60000
   spring.datasource.druid.use-global-data-source-stat=true
   spring.datasource.druid.validation-query=SELECT 1 FROM DUAL
   spring.datasource.druid.connection-properties=druid.stat.mergeSql=true;druid.stat.slowSqlMillis=500
   spring.datasource.druid.stat-view-servlet.login-username=admin
   spring.datasource.druid.stat-view-servlet.login-password=123
   spring.datasource.druid.stat-view-servlet.allow=
   #spring.datasource.druid.stat-view-servlet.deny=10.1.255.213
   spring.datasource.druid.web-stat-filter.exclusions=*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*
   ```

3. 创建service层。分为接口service接口类和impl接口实现类。（jpa正常配置即可。）

   在实现类中加上`@Service`注解。（注意：是dubbo的service，不是spring的service`import com.alibaba.dubbo.config.annotation.Service;`）

   在实现类中加上`@Component`注入spring容器中。

4. 在启动类上使用注解开启dubbo

   `@EnableDubbo(scanBasePackages = "com.springbootdemo.springbootdubboservice.service")`

   scanBasePackages中为需要提供的服务的service接口所在的文件。