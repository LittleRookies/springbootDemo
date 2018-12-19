package com.springbootdemo.springbootRedisPlus;

import com.springbootdemo.springbootRedisPlus.bean.RedisBean;
import com.springbootdemo.springbootRedisPlus.util.RedisObjectUtil;
import com.springbootdemo.springbootRedisPlus.util.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Little Rookies
 * @create 2018-12-19 10:39
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRedisPlusApplicationTests {
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private RedisObjectUtil redisObjectUtil;

    @Test
    public void test() {
        RedisBean redisBean = new RedisBean();
        redisBean.setAge("123");
        redisBean.setName("哈哈");
        redisObjectUtil.set("你好", redisBean);
        RedisBean bean = (RedisBean) redisObjectUtil.get("你好");
        System.out.println(bean.toString());
    }
}
