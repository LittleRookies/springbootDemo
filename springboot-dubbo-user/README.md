# springboot+jpa+dubbo 客户端

前提:启动zookeeper和服务器端

1. pom.xml

   ```xml
           <!--dubbo-->
           <dependency>
               <groupId>com.alibaba.boot</groupId>
               <artifactId>dubbo-spring-boot-starter</artifactId>
               <version>0.2.0</version>
           </dependency>
   ```

2. 配置文件

   ```properties
   dubbo.application.name=springboot-dubbo-user
   dubbo.registry.address=zookeeper://***.***.***.***:2181
   ```

3. 创建服务端的service接口类和实体类（注意：必须与服务端的service接口类完全相同，类内的`package`必须必须与服务器端的相同，不然无法注入。）

4. 在调用服务端的服务时需要用`@Reference`进行自动注入即可。

