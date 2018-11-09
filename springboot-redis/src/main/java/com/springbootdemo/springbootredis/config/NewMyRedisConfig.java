package com.springbootdemo.springbootredis.config;

import com.springbootdemo.springbootredis.entity.PersonEntity;
import com.springbootdemo.springbootredis.entity.StudentEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.util.Objects;

/**
 * 需要为每个实体类指定转化json方式
 *
 * @Author: Little Rookies
 * @Date: 2018/11/9 11:02
 */
@Configuration
public class NewMyRedisConfig {
    @Bean
    public RedisTemplate<Object, PersonEntity> PersonRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, PersonEntity> RedisTemplate = new RedisTemplate<Object, PersonEntity>();
        RedisTemplate.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<PersonEntity> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<PersonEntity>(PersonEntity.class);
        RedisTemplate.setDefaultSerializer(jackson2JsonRedisSerializer);
        return RedisTemplate;
    }

    @Bean
    public RedisTemplate<Object, StudentEntity> StudentRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, StudentEntity> RedisTemplate = new RedisTemplate<Object, StudentEntity>();
        RedisTemplate.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<StudentEntity> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<StudentEntity>(StudentEntity.class);
        RedisTemplate.setDefaultSerializer(jackson2JsonRedisSerializer);
        return RedisTemplate;
    }


    @Primary
    @Bean
    public RedisCacheManager personRedisCacheManager(RedisTemplate<Object, PersonEntity> PersonRedisTemplate) {
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(Objects.requireNonNull(PersonRedisTemplate.getConnectionFactory()));
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(PersonRedisTemplate.getValueSerializer()));
        return new RedisCacheManager(redisCacheWriter, redisCacheConfiguration);
    }

    @Bean
    public RedisCacheManager studenRedisCacheManager(RedisTemplate<Object, StudentEntity> StudentRedisTemplate) {
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(Objects.requireNonNull(StudentRedisTemplate.getConnectionFactory()));
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(StudentRedisTemplate.getValueSerializer()));
        return new RedisCacheManager(redisCacheWriter, redisCacheConfiguration);
    }
}
