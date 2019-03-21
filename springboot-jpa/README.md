# springboot+druid+jpa

1. 在引入spring-data-jpa的jar包

   ```xm
           <dependency>
               <groupId>org.springframework.boot</groupId>
               <artifactId>spring-boot-starter-data-jpa</artifactId>
           </dependency>
   ```

2. 创建entity实体类

   ```java
   //使用JPA注解配置映射关系
   @Entity(name = "person") //告诉JPA这是一个实体类（和数据表映射的类）//
   public class PersonEntity {
       private Integer id;
       private String firstName;
   
       @Id //这是一个主键
       @GeneratedValue(strategy = GenerationType.IDENTITY)//自增主键
       @Column(name = "id")
       public Integer getId() {
           return id;
       }
   
       public void setId(Integer id) {
           this.id = id;
       }
   
       @Basic
       @Column(name = "first_name")//这是和数据表对应的一个列
       public String getFirstName() {
           return firstName;
       }
   }
   ```

3. 创建repository接口继承JpaRepository接口

```java
//继承JpaRepository来完成对数据库的操作
public interface PersonRepository extends JpaRepository<PersonEntity, Integer> {
    List<PersonEntity> findAllByName(String name);

    //    模糊查询+分页
    @Query(value = "select p from person as p where name like %?1%")
    Page<PersonEntity> findByName(String name, Pageable pageable);
}

```

​		简单的sql可以直接用用spring-data-jpa的命名规范来定义。

​		复杂的查询需要自定义sql语句。
