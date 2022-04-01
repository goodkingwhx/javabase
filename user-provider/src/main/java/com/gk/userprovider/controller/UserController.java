package com.gk.userprovider.controller;

import com.gk.userapi.Person;
import com.gk.userapi.UserApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author goodking
 * @data 2022-03-25 11:09
 */

@RestController
public class UserController implements UserApi {

    @Value("${server.port}")
    String port;


    private AtomicInteger count = new AtomicInteger();

    @Override
    public String alive() {

        try {
            System.out.println("准备睡");
            //int i = 1/0;
            Thread.sleep(40);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //int i = count.getAndIncrement();
        //System.out.println(port+"====好的第：" + i + "次调用");
        return "Provider: port:" + port;
    }

   /* @Override
    public String alive() {
        return "yeah! I am here.-userprovider";
    }*/

    @Override
    public String getById(@RequestParam("id") Integer id) {
        return "这个id是： "+ id;
    }

    /**
     *写一个文档给谁看，只给php看吗
     *
     * 接口写了，只有java的客户端能用，php再去写文档.....
     * 服务名
     * 接口名
     * @return
     */

    @GetMapping("/getMap")
    public Map<Integer, String> getMap(@RequestParam("id") Integer id) {
        // TODO Auto-generated method stub
        System.out.println(id);
        return Collections.singletonMap(id, "mmeme");
    }
    @GetMapping("/getMap2")
    public Map<Integer, String> getMap2(Integer id,String name) {
        // TODO Auto-generated method stub
        System.out.println(id);
        return Collections.singletonMap(id, name);
    }

    @GetMapping("/getMap3")
    public Map<Integer, String> getMap3(@RequestParam Map<String, Object> map) {
        // TODO Auto-generated method stub
        System.out.println(map);
        return Collections.singletonMap(Integer.parseInt(map.get("id").toString()), map.get("name").toString());
    }


    @PostMapping("/postMap")
    public Map<Integer, String> postMap(@RequestBody Map<String, Object> map) {
        // TODO Auto-generated method stub
        System.out.println(map);
        return Collections.singletonMap(Integer.parseInt(map.get("id").toString()), map.get("name").toString());
    }

    @Override
    public Person postPerson(Person person) {

        System.out.println("persion: "+person);
        return person;
    }

}
