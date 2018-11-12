# springboot+rabbitmq

#### 声明

```java
//声明Direct交换机
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
```

#### 在service层声明监听对象

适用`@RabbitListener(queues = "")`注解声明

##### 将存储的数据转位json格式

默认情况下数据都会转化为序列化的形式存储，但可以在配置类中加入下面的代码转化为json格式

```java
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
```

