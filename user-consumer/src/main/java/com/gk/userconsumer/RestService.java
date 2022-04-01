package com.gk.userconsumer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author goodking
 * @data 2022-03-29 22:59
 */
@Service
public class RestService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(defaultFallback = "back")
    public String alive() {

        String url = "http://user-provider/alive";
        String str = restTemplate.getForObject(url, String.class);

        return str;
    }

    public String back() {
        return "呵呵Rest";
    }
}
