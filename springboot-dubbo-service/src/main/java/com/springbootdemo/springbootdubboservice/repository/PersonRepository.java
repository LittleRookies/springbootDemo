package com.springbootdemo.springbootdubboservice.repository;

import com.springbootdemo.springbootdubboservice.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: Little Rookies
 * @Date: 2018/11/13 14:31
 */
public interface PersonRepository extends JpaRepository<Person, Integer> {
    Person findFirstById(Integer id);
}
