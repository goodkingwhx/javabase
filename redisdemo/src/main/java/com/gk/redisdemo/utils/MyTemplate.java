package com.gk.redisdemo.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

/**
 * @author goodking
 * @data 2022-03-02 19:31
 */
@Configuration
public class MyTemplate {

    @Bean
    public StringRedisTemplate ooxx(RedisConnectionFactory fc, ObjectMapper mapper){
        StringRedisTemplate tp = new StringRedisTemplate(fc);
        tp.setHashValueSerializer(new Jackson2JsonRedisSerializer<Object>(Object.class));

        return tp;
    }
}
