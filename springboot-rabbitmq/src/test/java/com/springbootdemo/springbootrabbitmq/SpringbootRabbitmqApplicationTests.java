package com.springbootdemo.springbootrabbitmq;

import com.springbootdemo.springbootrabbitmq.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRabbitmqApplicationTests {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void contextLoads() {
    }


    @Test
    public void direct() {
        Person person = new Person();
        person.setAge(15);
        person.setName("你好");
        rabbitTemplate.convertAndSend("directExchange", "direct", person);

//
//        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
//        rabbitTemplate.convertAndSend("FANOUT_EXCHANGE", "", "", correlationData);
    }

}
