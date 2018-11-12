# springboot+elasticsearch

1. 引入jar包(注意与elasticsearch版本相同)

   ```xml
   <dependency>
               <groupId>org.springframework.boot</groupId>
               <artifactId>spring-boot-starter-data-elasticsearch</artifactId>
           </dependency>
   ```

2. 配置application.properties文件。

   ```properties
   spring.data.elasticsearch.cluster-name=docker-cluster
   spring.data.elasticsearch.cluster-nodes=localhost:9300
   ```

3. 创建实体类。在实体类上标注`@Document(indexName = "mydocument", type = "book")`，**indexName**为索引名称（一定不能有大写字母），**type**为类型。

4. 创建Repository类。方式与spring-data-jpa相同。
