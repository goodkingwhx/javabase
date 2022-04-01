package com.gk.eurekaconsumer.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * @author goodking
 * @data 2022-03-22 21:45
 */
@RestController
public class MainContriller {

    @Autowired
    DiscoveryClient client;

    @Autowired
    EurekaClient client2;

    @Autowired
    LoadBalancerClient lb;

    @GetMapping("getHi")
    public String getHi() {
        return "Hi consume r!";
    }
    @GetMapping("/client")
    public String client() {
        List<String> services = client.getServices();
        services.stream().collect(Collectors.toList()).forEach(System.out::println);
        return "hi";
    }

    @GetMapping("/client2")
    public Object client2() {

        return client.getInstances("provider");
    }

    @GetMapping("/client3")
    public String client3() {
        List<ServiceInstance> instances = client.getInstances("provider");
        instances.stream().collect(Collectors.toList()).forEach(System.out::println);

        return Arrays.asList(instances).toString();
    }

    @GetMapping("/client4")
    public Object client4() {
        //具体服务
        //List<InstanceInfo> instances = client2.getInstancesById("localhost:provider:80");

        //服务列表
        List<InstanceInfo> instances = client2.getInstancesByVipAddress("provider", false);
        instances.stream().collect(Collectors.toList()).forEach(System.out::println);
        if (instances.size()>0) {
            InstanceInfo instanceInfo = instances.get(0);
            if (instanceInfo.getStatus() == InstanceInfo.InstanceStatus.UP) {
                String url = "http://"+instanceInfo.getHostName() +":"+ instanceInfo.getPort()+"/getHi";
                System.out.println("url: "+ url);
                //用RestTemplate  远程服务调用
                RestTemplate restTemplate = new RestTemplate();
                String respStr = restTemplate.getForObject(url, String.class);
                System.out.println("respStr:" + respStr);
            }
        }
        return "xxoo";
    }

    @GetMapping("/client5")
    public Object client5() {

        //ribbon完成客户端的负载均衡，过滤掉down了的节点
        ServiceInstance instance = lb.choose("provider");

        String url = "http://"+instance.getHost() +":"+ instance.getPort()+"/getHi";
        System.out.println("url: "+ url);
        //用RestTemplate  远程服务调用
        RestTemplate restTemplate = new RestTemplate();
        String respStr = restTemplate.getForObject(url, String.class);
        System.out.println("respStr:" + respStr);
        return "xxoo";
    }

}
