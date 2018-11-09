package com.springbootdemo.springbootredis.service;

import com.springbootdemo.springbootredis.entity.StudentEntity;
import com.springbootdemo.springbootredis.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Service;

/**
 * @Author: Little Rookies
 * @Date: 2018/11/8 17:22
 */
@EnableCaching
@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Qualifier("studenRedisCacheManager")
    @Autowired
    RedisCacheManager redisCacheManager;

    //方法一注解方式
//    @Cacheable(cacheNames = "Student", key = "#id", cacheManager = "studenRedisCacheManager")
    public StudentEntity find(Integer id) {
        StudentEntity firstById = studentRepository.findFirstById(id);
        //方法二
        Cache cache = redisCacheManager.getCache("Student");
        cache.put(id, firstById);
        //
        return firstById;
    }
}
