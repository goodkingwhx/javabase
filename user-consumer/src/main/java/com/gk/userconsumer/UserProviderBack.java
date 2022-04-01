package com.gk.userconsumer;

import com.gk.userapi.Person;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author goodking
 * @data 2022-03-29 21:20
 */
@Component()
public class UserProviderBack implements ConsumerApi {
    @Override
    public String alive() {
        /**
         * 此处要有兜底信息，也就是如果服务不可用就调整到下个版本，而不是说报错信息
         */
        return "降级了";
    }

    @Override
    public String getById(Integer id) {
        return null;
    }

    @Override
    public Map<Integer, String> getMap(Integer id) {
        return null;
    }

    @Override
    public Map<Integer, String> getMap2(Integer id, String name) {
        return null;
    }

    @Override
    public Map<Integer, String> getMap3(Map<String, Object> map) {
        return null;
    }

    @Override
    public Map<Integer, String> postMap(Map<String, Object> map) {
        return null;
    }

    @Override
    public Person postPerson(Person person) {
        return null;
    }
}
