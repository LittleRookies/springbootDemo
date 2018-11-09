package com.springbootdemo.springbootredis.repository;

import com.springbootdemo.springbootredis.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: Little Rookies
 * @Date: 2018/11/8 17:20
 */
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
    StudentEntity findFirstById(Integer id);
}
