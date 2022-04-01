package com.gk.proxy;

import com.gk.service.Calculator;
import com.gk.util.LogUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author goodking
 * @data 2022-02-07 15:55
 * JDK的自动动态代理，是需要接口的
 * 另外一种是cglib不需要接口
 */
public class CalculatorProxy {

    public static Calculator getProxy(Calculator calculator) {

        ClassLoader loader = calculator.getClass().getClassLoader();
        Class<?>[] interfaces = calculator.getClass().getInterfaces();
        InvocationHandler handler = new InvocationHandler(){

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                try {
                    Object result = null;
                    LogUtils.start(method,Integer.parseInt(args[0].toString()),Integer.parseInt(args[1].toString()));
                    result = method.invoke(calculator, args);
                    LogUtils.stop(method,Integer.parseInt(result.toString()));
                    return result;
                }catch (Exception e){

                } finally {

                }
                return null;
            }
        };

        Object o = Proxy.newProxyInstance(loader, interfaces, handler);
        return (Calculator) o;
    }
}
