package com.gk.eurekaprovider.controller;

import com.gk.eurekaprovider.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author goodking
 * @data 2022-03-22 21:20
 */
@RestController
public class MainController {

    @Value("${server.port}")
    String port;

    @RequestMapping("/getHi")
    public String getHi() {
        return "Hi,I am provider and port is: "+port;
    }

    @RequestMapping("/getMap")
    public Map<String,String> getMap() {

        return Collections.singletonMap("port",port);
    }

    @RequestMapping("/getObj")
    public Person getObj() {
        Person p = new Person(1001,"zhangsan");
        return p;
    }
    @RequestMapping("/getObj2")
    public Person getObj2(@RequestParam String name) {
        Person p = new Person(1001,name);
        return p;
    }

    @RequestMapping("/postLocation")
    public URI postParam(@RequestBody Person person, HttpServletResponse response) throws Exception {
        URI uri = new URI("https://www.baidu.com/s?wd=" + person.getName());
        response.addHeader("Location",uri.toString());

        return uri;
    }



    @Autowired
    HealthStatusService hsrv;

    @GetMapping("/health")
    public String health(@RequestParam("status") Boolean status) {
        hsrv.setStatus(status);
        return hsrv.getStatus();
    }
}
