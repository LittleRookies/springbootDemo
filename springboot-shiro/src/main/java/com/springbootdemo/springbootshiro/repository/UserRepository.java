package com.springbootdemo.springbootshiro.repository;

import com.springbootdemo.springbootshiro.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @Author: Little  Rookies
 * @Date: 2018-11-29 15:44
 */
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    @Query(nativeQuery = true, value = "select * from user where account=:name")
    UserEntity findFirstByAccount(@Param("name") String name);
}
