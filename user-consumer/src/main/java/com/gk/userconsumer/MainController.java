package com.gk.userconsumer;

import com.gk.userapi.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author goodking
 * @data 2022-03-25 11:17
 */
@RestController
public class MainController {

    @Value("${server.port}")
    String port;

    @Autowired
    ConsumerApi api;

    @Autowired
    RestService restService;

    @GetMapping("/alive2")
    public String getAlive2() {


        return "Consumet: "+port+"->>>"+restService.alive();
    }

    @GetMapping("/alive")
    public String getAlive() {

        return api.alive();
    }

    @GetMapping("/getById")
    public String getById(@RequestParam Integer id) {
        return api.getById(id);
    }

    @GetMapping("/map")
    public Map<Integer, String> map(Integer id) {
        System.out.println(id);
        return api.getMap(id);
    }

    @GetMapping("/map2")
    public Map<Integer, String> map2(Integer id,String name) {
        System.out.println(id);
        return api.getMap2(id,name);
    }


    @GetMapping("/map3")
    public Map<Integer, String> map3(@RequestParam Map<String, Object> map) {
//		System.out.println(id);
//		HashMap<String, Object> map = new HashMap<>(2);
//
//		map.put("id", id);
//		map.put("name", name);
//		syso
        System.out.println(map);
        return api.getMap3(map);
    }


    @GetMapping("/map4")
    public Map<Integer, String> map4(@RequestParam Map<String, Object> map) {
//		System.out.println(id);
//		HashMap<String, Object> map = new HashMap<>(2);
//
//		map.put("id", id);
//		map.put("name", name);
//		syso
        System.out.println(map);
        return api.postMap(map);
    }

    @GetMapping("/postPerson")
    public Person postPerson(@RequestParam Map<String,Object> map) {
        System.out.println(map);
        Person person = new Person(Integer.parseInt(map.get("id").toString()),"xxoo");
        System.out.println("person: " + person);
        return api.postPerson(person);
    }

}
