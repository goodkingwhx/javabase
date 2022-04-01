package com.gk.userconsumer;

import com.gk.userapi.UserApi;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**fallback = UserProviderBack.class 是单例的
 * @author goodking
 * @data 2022-03-25 11:19
 */
//@FeignClient(name="xxoo",url = "http://localhost:89")
//@FeignClient(name = "user-provider",fallback = UserProviderBack.class)
@FeignClient(name = "user-provider",fallbackFactory = UserProviderFactory.class)
public interface ConsumerApi extends UserApi {

   /*     //看API文档
    @GetMapping("/alive")
    public String alive();

    @GetMapping("/register")
    public String register();
*/

    /**
     * 这里的GetMapping是给feign看的，配合上面url  (user-provider)拼接处理
     * @RequestParam() 也是给feign看的  传参
     */

/**
     * 这种方式跟RestTemplate没有区别，还是不爽
     * 没有代码入侵
     * 方便做异构系统
     */
}
