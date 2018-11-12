package com.springbootdemo.springbootrabbitmq.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Little Rookies
 * @Date: 2018/11/9 14:56
 */
@Configuration
public class MyRabbitmqConfig {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    private Logger log = LoggerFactory.getLogger(MyRabbitmqConfig.class);

    @Bean
    public AmqpTemplate amqpTemplate() {
        // 使用jackson 消息转换器
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        rabbitTemplate.setEncoding("UTF-8");
        // 消息发送失败返回到队列中，yml需要配置 publisher-returns: true
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setReturnCallback((message, replyCode, replyText, exchange, routingKey) -> {
            String correlationId = message.getMessageProperties().getCorrelationId();
            log.debug("消息：{} 发送失败, 应答码：{} 原因：{} 交换机: {}  路由键: {}", correlationId, replyCode, replyText, exchange, routingKey);
        });
        // 消息确认，yml需要配置 publisher-confirms: true
        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
            if (ack) {
                log.debug("消息发送到exchange成功,id: {}", correlationData.getId());
            } else {
                log.debug("消息发送到exchange失败,原因: {}", cause);
            }
        });
        return rabbitTemplate;
    }

    //-----------------------------------------------------声明Direct交换机------------------------------------------------------
    @Bean
    public Exchange directExchange() {
        return ExchangeBuilder.directExchange("directExchange").durable(true).build();
    }

    @Bean
    public Queue directQueue() {
        return QueueBuilder.durable("directQueue").build();
    }

    @Bean
    public Binding directBind(
            @Qualifier("directExchange") Exchange exchange,
            @Qualifier("directQueue") Queue queue
    ) {
        return BindingBuilder.bind(queue).to(exchange).with("direct").noargs();
    }

    //-----------------------------------------------------声明fanout交换机------------------------------------------------------
    @Bean
    public FanoutExchange fanoutExchange() {
        return (FanoutExchange) ExchangeBuilder.fanoutExchange("fanoutExchange").durable(true).build();
    }

    @Bean
    public Queue fanoutQueueA() {
        return QueueBuilder.durable("fanoutQueueA").build();
    }

    @Bean
    public Queue fanoutQueueB() {
        return QueueBuilder.durable("fanoutQueueB").build();
    }

    @Bean
    public Binding bindingA(@Qualifier("fanoutQueueA") Queue queue,
                            @Qualifier("fanoutExchange") FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }

    @Bean
    public Binding bindingB(@Qualifier("fanoutQueueB") Queue queue,
                            @Qualifier("fanoutExchange") FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }
}
