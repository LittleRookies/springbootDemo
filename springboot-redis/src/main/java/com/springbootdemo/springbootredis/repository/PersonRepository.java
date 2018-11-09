package com.springbootdemo.springbootredis.repository;

import com.springbootdemo.springbootredis.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: Little Rookies
 * @Date: 2018/11/8 17:17
 */
public interface PersonRepository extends JpaRepository<PersonEntity, Integer> {
    PersonEntity findFirstById(Integer id);
}
