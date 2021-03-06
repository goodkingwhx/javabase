package com.gk.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author goodking
 * @data 2022-03-16 15:34
 */
public class LambdaDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("running");
            }
        });
        thread.start();

        new Thread(()->{
            System.out.println("running2...");
        }).start();


        List<String> list = Arrays.asList("java", "javascripte", "python","scala");

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                return o1.length()-o2.length();
            }
        });
        for (String s : list) {
            System.out.println(s);
        }

        System.out.println("=========");
        Collections.sort(list,(a,b)->a.length()-b.length());
        list.forEach(System.out::println);
    }


}
