package com.gk.util;

import java.lang.reflect.Method;

/**
 * @author goodking
 * @data 2022-02-07 15:47
 */
public class LogUtils {

    public static void start(Method method,int i, int j) {
        String name = method.getName();
        System.out.println(name+"方法开始执行,参数是:"+ i + "," + j);
    }

    public static void stop(Method method,int result) {
        String name = method.getName();
        System.out.println(name+"方法完成执行,结果是:"+ result);
    }

    public static void logException(Method method,Exception e) {
        String name = method.getName();
        System.out.println(name+"方法报错,错误信息是:"+ e.getMessage());
    }

    public static void logFinally(Method method) {
        String name = method.getName();
        System.out.println(name+"方法执行结束....over!");
    }

}
