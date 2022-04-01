package com.gk.redisdemo.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gk.redisdemo.bean.Person;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.hash.Jackson2HashMapper;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author goodking
 * @data 2022-03-02 16:38
 */
@Component
public class RedisTest {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
            @Qualifier("ooxx")
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    ObjectMapper objectMapper;



    public void testRedis() {
        /*redisTemplate.opsForValue().set("hello","china");
        System.out.println(redisTemplate.opsForValue().get("hello"));*/

        /*stringRedisTemplate.opsForValue().set("hello1","china");
        System.out.println(stringRedisTemplate.opsForValue().get("hello1"));*/

       /* RedisConnection conn = redisTemplate.getConnectionFactory().getConnection();
        conn.set("hello02".getBytes(),"mashibing".getBytes());
        System.out.println(new String(conn.get("hello02".getBytes())));

        HashOperations<String, Object, Object> hash = stringRedisTemplate.opsForHash();
        hash.put("sean","name","段磊");
        hash.put("sean","age","32");

        System.out.println(hash.entries("sean"));*/

        Person p = new Person();
        p.setAge(13);
        p.setName("张三");

        /*stringRedisTemplate.setHashValueSerializer(new Jackson2JsonRedisSerializer<Object>(Object.class));
        Jackson2HashMapper jm = new Jackson2HashMapper(objectMapper, false);
        stringRedisTemplate.opsForHash().putAll("sean00",jm.toHash(p));
        Map<Object, Object> map = stringRedisTemplate.opsForHash().entries("sean00");
        Person person = objectMapper.convertValue(map, Person.class);
        System.out.println(person);*/

        // @Qualifier("ooxx") 使用自定义的template就不需要写序列化了，因为自定义的时候统一写了
        Jackson2HashMapper jm = new Jackson2HashMapper(objectMapper, false);
        stringRedisTemplate.opsForHash().putAll("sean04",jm.toHash(p));
        Map<Object, Object> map = stringRedisTemplate.opsForHash().entries("sean04");
        Person person = objectMapper.convertValue(map, Person.class);
        System.out.println(person);

        //发布订阅 -- 发布
        stringRedisTemplate.convertAndSend("xxoo","hello world!");

        RedisConnection cc = stringRedisTemplate.getConnectionFactory().getConnection();
        cc.subscribe(new MessageListener() {
            @Override
            public void onMessage(Message message, byte[] pattern) {
                byte[] body = message.getBody();
                System.out.println(new String(body));
            }
        }, "xxoo".getBytes());
        while (true) {

        }

    }

    public void getDataByRedis() {

        HashOperations<String, Object, Object> hash = stringRedisTemplate.opsForHash();


        System.out.println(hash.entries("sean"));
    }

}
