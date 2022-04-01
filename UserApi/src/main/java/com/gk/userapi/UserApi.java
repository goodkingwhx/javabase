package com.gk.userapi;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author goodking
 * @data 2022-03-25 21:33
 */
//@RequestMapping("/User")
public interface UserApi {

    /**
     * 侧首实时调用
     * @return
     */
    @GetMapping("/alive")
    public String alive();

    @GetMapping("/getById")
    public String getById(@RequestParam("id") Integer id);

    @GetMapping("/getMap")
    Map<Integer, String> getMap(@RequestParam("id") Integer id);
    @GetMapping("/getMap2")
    Map<Integer, String> getMap2(@RequestParam("id") Integer id,@RequestParam("name") String name);

    @GetMapping("/getMap3")
    Map<Integer, String> getMap3(@RequestParam Map<String, Object> map);

    @PostMapping("/postMap")
    Map<Integer, String> postMap(Map<String, Object> map);

    @PostMapping("/postPerson")
    Person postPerson(@RequestBody Person person);

}
