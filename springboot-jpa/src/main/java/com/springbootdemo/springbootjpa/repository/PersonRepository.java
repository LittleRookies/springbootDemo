package com.springbootdemo.springbootjpa.repository;

import com.springbootdemo.springbootjpa.entity.PersonEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Author: Little Rookies
 * @Date: 2018/11/8 09:46
 */
//继承JpaRepository来完成对数据库的操作
public interface PersonRepository extends JpaRepository<PersonEntity, Integer> {
    List<PersonEntity> findAllByName(String name);

    //    模糊查询+分页
    @Query(value = "select p from person as p where name like %?1%")
    Page<PersonEntity> findByName(String name, Pageable pageable);
}
