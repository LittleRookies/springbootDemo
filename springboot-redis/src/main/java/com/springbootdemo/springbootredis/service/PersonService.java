package com.springbootdemo.springbootredis.service;

import com.springbootdemo.springbootredis.entity.PersonEntity;
import com.springbootdemo.springbootredis.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

/**
 * @Author: Little Rookies
 * @Date: 2018/11/8 17:22
 */
@EnableCaching //开启缓存
@CacheConfig(cacheNames = "person") //配置缓存名称
@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;


    /*
     *      cacheNames/value：指定缓存组件的名字;将方法的返回结果放在哪个缓存中，是数组的方式，可以指定多个缓存；
     *
     *      key：缓存数据使用的key；可以用它来指定。默认是使用方法参数的值  1-方法的返回值
     *              编写SpEL； #i d;参数id的值   #a0  #p0  #root.args[0]
     *              getEmp[2]
     *
     *      keyGenerator：key的生成器；可以自己指定key的生成器的组件id
     *              key/keyGenerator：二选一使用;
     *
     *
     *      cacheManager：指定缓存管理器；或者cacheResolver指定获取解析器
     *
     *      condition：指定符合条件的情况下才缓存；
     *              ,condition = "#id>0"
     *          condition = "#a0>1"：第一个参数的值》1的时候才进行缓存
     *
     *      unless:否定缓存；当unless指定的条件为true，方法的返回值就不会被缓存；可以获取到结果进行判断
     *              unless = "#result == null"
     *              unless = "#a0==2":如果第一个参数的值是2，结果不缓存；
     *      sync：是否使用异步模式
     *      */
    @Cacheable(key = "#id", unless = "#result==null")
    public PersonEntity find(Integer id) {
        System.out.println("连接sql");
        return personRepository.findFirstById(id);
    }


    //    即执行方法有更新缓存，主要用于更新方法
    @CachePut(key = "#result.id")
    public PersonEntity save(PersonEntity personEntity) {
        personRepository.save(personEntity);
        return personEntity;
    }

    //    删除指定缓存
    /*
     *  beforeInvocation = false：缓存的清除是否在方法之前执行
     *      默认代表缓存清除操作是在方法执行之后执行;如果出现异常缓存就不会清除
     *
     *  beforeInvocation = true：
     *      代表清除缓存操作是在方法运行之前执行，无论方法是否出现异常，缓存都清除
     *
     */
    @CacheEvict(key = "#id")
    public void del(Integer id) {
        personRepository.deleteById(id);
    }

    // @Caching 定义复杂的缓存规则
    @Caching(
            cacheable = {
                    @Cacheable(key = "#result.age")
            },
            put = {
                    @CachePut(key = "#result.id"),
                    @CachePut(key = "#result.firstName")
            }
    )
    public PersonEntity select(Integer id) {
        return personRepository.findFirstById(id);
    }
}
