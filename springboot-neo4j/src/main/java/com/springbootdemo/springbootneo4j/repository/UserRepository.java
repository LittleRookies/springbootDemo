package com.springbootdemo.springbootneo4j.repository;


import com.springbootdemo.springbootneo4j.entity.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;


import java.util.List;

/**
 * @Author: Little Rookies
 * @Date: 2018-12-04 16:41
 */
public interface UserRepository extends Neo4jRepository<User, Long> {
    @Query("MATCH (n:User) RETURN n ")
    List<User> getUserNodeList();

    @Query("create (n:User{age:{age},name:{name}}) RETURN n ")
    List<User> addUserNodeList(@Param("name") String name, @Param("age") int age);
}
