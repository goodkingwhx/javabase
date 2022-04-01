package com.gk.lambda.founctionref;

import java.util.function.Function;

/**
 * @author goodking
 * @data 2022-03-16 17:37
 */
public class Test1 {

    public static void main(String[] args) {
        Function<String,Integer> f1 = (str)->{return str.length();};
        System.out.println(f1.apply("abc"));
    }
}
