package com.gk.eurekaconsumer.controller;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * @author goodking
 * @data 2022-03-22 21:45
 */
@RestController
public class MainContriller3 {

    //资源实现定义，肯定不能写getHi什么的
    /**
     * http://xxx/User
     * http://xxx/v1/User/getUserList  Get
     * http://xxx/v1/User/deleteById   Get
     * http://xxx/v1/Users    Get 也可以约定，访问这个请求的时候，可以获取getUserList
     * http://xxx/v1/User/addUser  Get
     * http://xxx/v1/Users/1  Get=获取id1这个用户，delete请求=删除，put=修改
     *
     * 针对单表不再重复crud SpringData Rest
     */


    @Autowired
    RestTemplate restTemplate;

    /**
     * getRestTemplate() 这个方法上面加@LoadBalanced
     * @return
     */
    @GetMapping("/client10")
    public Object client10() {
        //自动处理URL

        String url = "http://provider/getHi";
        //用RestTemplate  远程服务调用
        String respStr = restTemplate.getForObject(url, String.class);

        ResponseEntity<String> entity = restTemplate.getForEntity(url, String.class);
        System.out.println("entity: " + entity);

        System.out.println("respStr:" + respStr);
        return respStr;
    }

    @GetMapping("/client11")
    public Map<String,String> client11() {
        //自动处理URL

        String url = "http://provider/getMap";
        //用RestTemplate  远程服务调用
        Map map = restTemplate.getForObject(url, Map.class);

        System.out.println(map);
        return map;
    }

    @GetMapping("/client12")
    public Object client12() {

        String url = "http://provider/getObj";
        //用RestTemplate  远程服务调用
        Person person = restTemplate.getForObject(url, Person.class);

        System.out.println("respObj:" + person);
        return person;
    }

    @GetMapping("/client13")
    public Object client13() {

        String url = "http://provider/getObj2?name={1}";
        //用RestTemplate  远程服务调用
        Person person = restTemplate.getForObject(url, Person.class,"maxiaoliu6666");

        System.out.println("respObj:" + person);
        return person;
    }

    @GetMapping("/client14")
    public Object client14() {

        String url = "http://provider/getObj2?name={name}";
        Map<String,String> map = Collections.singletonMap("name", "xiao66");
        //用RestTemplate  远程服务调用
        Person person = restTemplate.getForObject(url, Person.class,map);

        System.out.println("respObj:" + person);
        return person;
    }

    /**
     *
     *
     * ==============================================post请求===================================================
     */

    @GetMapping("/client15")
    public Object client15(HttpServletResponse response) throws Exception {

        String url = "http://provider/postLocation";
        Map<String,String> map = Collections.singletonMap("name", "memeda");
        //用RestTemplate  远程服务调用
        URI location = restTemplate.postForLocation(url,map,Person.class);

        System.out.println("respObj:" + location);

        response.sendRedirect(String.valueOf(location.toURL()));
        return location;
    }




}
