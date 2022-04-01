package com.gk.redisdemo;

import com.gk.redisdemo.demo.RedisTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class RedisdemoApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(RedisdemoApplication.class, args);
        RedisTest red = ctx.getBean(RedisTest.class);
        red.testRedis();
        System.out.println("============================");
        //red.getDataByRedis();
    }

}
