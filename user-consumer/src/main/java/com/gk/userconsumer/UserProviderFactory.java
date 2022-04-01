package com.gk.userconsumer;

import com.gk.userapi.Person;
import feign.FeignException;
import feign.hystrix.FallbackFactory;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author goodking
 * @data 2022-03-29 22:12
 */
@Component
public class UserProviderFactory implements FallbackFactory<ConsumerApi> {

    @Override
    public ConsumerApi create(Throwable throwable) {
        return new ConsumerApi() {
            @Override
            public String alive() {
                System.out.println(throwable);
                if (throwable instanceof FeignException.InternalServerError) {
                    return "远程服务器异常500"+throwable.getLocalizedMessage();
                }else {
                    return "呵呵哒";
                }
                /*throwable.printStackTrace();
                System.out.println(ToStringBuilder.reflectionToString(throwable));*/
                //return "呵呵";
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
        };
    }
}
