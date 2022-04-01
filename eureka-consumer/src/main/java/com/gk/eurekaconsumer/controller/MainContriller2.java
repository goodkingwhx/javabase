package com.gk.eurekaconsumer.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


/**
 * @author goodking
 * @data 2022-03-22 21:45
 */
@RestController
public class MainContriller2 {

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
    DiscoveryClient client;

    @Autowired
    EurekaClient client2;

    @Autowired
    LoadBalancerClient lb;


    @Autowired
    RestTemplate restTemplate;
    @GetMapping("/client6")
    public Object client6() {

        //ribbon完成客户端的负载均衡，过滤掉down了的节点
        ServiceInstance instance = lb.choose("provider");

        String url = "http://"+instance.getHost() +":"+ instance.getPort()+"/getHi";
        System.out.println("url: "+ url);
        //用RestTemplate  远程服务调用
        String respStr = restTemplate.getForObject(url, String.class);
        System.out.println("respStr:" + respStr);
        return respStr;
    }

    @GetMapping("/client7")
    public Object client7() {

        List<ServiceInstance> instances = client.getInstances("provider");
        System.out.println("instance:" + instances);
        //自定义轮询算法
        //随机
        int nextInt = new Random().nextInt(instances.size());
        AtomicInteger atomicInteger = new AtomicInteger();
        int i = atomicInteger.getAndIncrement();
        //轮询
        instances.get(i % instances.size());
        ServiceInstance instance = instances.get(nextInt);
        //权重
        for (ServiceInstance serviceInstance : instances) {
            //int quanzhong = (serviceInstance.getMetadata();//权重1-9
        }
        //ribbon完成客户端的负载均衡，过滤掉down了的节点
        //ServiceInstance instance = lb.choose("provider");

        String url = "http://"+instance.getHost() +":"+ instance.getPort()+"/getHi";
        System.out.println("url: "+ url);
        //用RestTemplate  远程服务调用
        String respStr = restTemplate.getForObject(url, String.class);
        System.out.println("respStr:" + respStr);
        return respStr;
    }


    /**
     * 使用yml文件配置的方法
     * provider:
     *   ribbon:
     *     NFLoadBalancerRuleClassName: 'com.netflix.loadbalancer.RandomRule'
     * @return
     */
    @GetMapping("/client8")
    public Object client8() {
        //ribbon完成客户端的负载均衡，过滤掉down了的节点
        ServiceInstance instance = lb.choose("provider");

        String url = "http://"+instance.getHost() +":"+ instance.getPort()+"/getHi";
        System.out.println("url: "+ url);
        //用RestTemplate  远程服务调用
        String respStr = restTemplate.getForObject(url, String.class);
        System.out.println("respStr:" + respStr);
        return respStr;
    }

    /**
     * getRestTemplate() 这个方法上面加@LoadBalanced
     * 如果加上了这个注解，就得把所有的轮询策略全部注释掉，包括@Bean和yml文件中的
     * @return
     */
    @GetMapping("/client9")
    public Object client9() {
        //自动处理URL

        String url = "http://provider/getHi";
        //用RestTemplate  远程服务调用
        String respStr = restTemplate.getForObject(url, String.class);
        System.out.println("respStr:" + respStr);
        return respStr;
    }




}
