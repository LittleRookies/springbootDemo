package com.springbootdemo.springbootrabbitmq.service;

import com.springbootdemo.springbootrabbitmq.bean.Person;
import com.springbootdemo.springbootrabbitmq.util.JsonUtil;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @Author: Little Rookies
 * @Date: 2018/11/9 15:46
 */
@Service
public class PeopleService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    //    监听器
    @RabbitListener(queues = "directQueue")
    public void listener(Message message) throws IOException {
        Person person = JsonUtil.getMapper().readValue(message.getBody(), Person.class);
        System.out.println(person.toString());
        System.out.println("结束");
    }

    //    向交换机发送队列信息
    public void send(Person person) {
        rabbitTemplate.convertAndSend("directExchange", "direct", person);
    }

}
