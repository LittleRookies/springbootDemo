# springboot-redis

#### pom.xml

```xml
 		<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-cache</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-redis</artifactId>
        </dependency>
```

## **注解**

springboot的缓存操作主要靠4个注解`@Cacheable、@CachePut、@CacheEvict、@EnableCaching`。

##### `@Cacheable`:如果缓存没有则存入缓存，如果缓存存在结果则直接放回结果不执行方法。（用于select操作后）

#### `@CachePut`：执行方法，然后将结果放入缓存。（用于update操作后）

####`@CacheEvict`:删除缓存中的数据。（用于DELETE操作后）

#### `@EnableCaching`：启动缓存。（放在启动类上则在全局开启缓存，如果只在service类上则是适用于该类。）

## **数据存储形式**

在网上查资料后发现，在redis的存储形式主要分两种：json和序列化。

json形式可以直接在reids中查看修改，但是存储量大，转化需要时间。适用于小数据量的存储。

序列化形式存储无法直接查看修改，但是存储量小不。适用于大数据的存储。

#### 序列化形式存储

只需要在在实体类中实现`Serializable`接口接可以了，剩下的交给springboot自己处理就可以了。

```java
public class PersonEntity implements Serializable {}
```

#### json

配置一个redisconfig

```java
@Configuration
public class MyRedisConfig {
    @Bean
    public RedisTemplate<Object, Object> PersonRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> RedisTemplate = new RedisTemplate<Object, Object>();
        RedisTemplate.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(Object.class);
        RedisTemplate.setDefaultSerializer(jackson2JsonRedisSerializer);
        return RedisTemplate;
    }
    
    @Primary
    @Bean
    public RedisCacheManager personRedisCacheManager(RedisTemplate<Object, Object> PersonRedisTemplate) {
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(Objects.requireNonNull(PersonRedisTemplate.getConnectionFactory()));
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(PersonRedisTemplate.getValueSerializer()));
        return new RedisCacheManager(redisCacheWriter, redisCacheConfiguration);
    }
}
```

然后在注解中通过cacheManager指定RedisCacheManager的bean的id。

如果有多个RedisCacheManager则需要通过`@Primary`指定一个默认的redis缓存管理器。