package com.gk.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author goodking
 * @data 2022-02-07 15:47
 */
@Aspect
@Component
public class LogUtils {


    @Pointcut(value = "execution( public Integer com.gk.service.MyCalculator.*(Integer,*))")
    public void myPointCut(){}

    @Before(value = "myPointCut()")
    public static void start(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        Object[] args = joinPoint.getArgs();
        System.out.println(signature.getName()+"方法开始执行：参数是:"+args[0]+","+args[1]);
    }

    @AfterReturning(value = "execution( public Integer com.gk.service.MyCalculator.*(Integer,Integer))",returning = "obj")
    public static void stop(JoinPoint joinPoint,Object obj){
        Signature signature = joinPoint.getSignature();
        System.out.println(signature.getName()+"方法执行结束，结果是："+obj);
    }

    @AfterThrowing(value = "execution( public Integer com.gk.service.MyCalculator.*(Integer,Integer))",throwing = "e")
    public static void logException(JoinPoint joinPoint,Exception e){
        Signature signature = joinPoint.getSignature();
        System.out.println(signature.getName()+"方法抛出异常："+e.getMessage());
    }

    @After("execution( public Integer com.gk.service.MyCalculator.*(Integer,Integer))")
    public static void logFinally(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        System.out.println(signature.getName()+"方法执行结束。。。。。over");

    }

    @Around("myPointCut()")
    public Object around(ProceedingJoinPoint pjp){
        Signature signature = pjp.getSignature();
        Object[] args = pjp.getArgs();
        Object result = null;
        try {
            System.out.println("环绕通知start:"+signature.getName()+"方法开始执行，参数为："+ Arrays.asList(args));
            // 通过反射的方式调用目标的方法，相当于执行method.invoke()，可以自己修改结果值
            result = pjp.proceed(args);
            System.out.println("环绕通知stop:"+signature.getName()+"方法执行结束！");

        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("环绕异常通知："+signature.getName()+"通知异常");
        } finally {
            System.out.println("环绕返回通知："+signature.getName()+"方法返回结果是："+result);
        }

        return result;

    }

}
