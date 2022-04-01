package com.gk.lambda.test;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author goodking
 * @data 2022-03-20 20:50
 */
public class Test01 {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("23", "3", "4", "34", "21");

        int sum = list1.stream().filter(x -> Integer.valueOf(x) % 2 == 0).mapToInt(x -> Integer.parseInt(x)).sum();
        System.out.println(sum);

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9,2,2,3,4);
        System.out.println("max: "+list.stream().max((a, b) -> a - b).get());
        System.out.println("min: "+list.stream().min((a,b)->a-b).get());

        // 不用max和min 求最大值和最小值
        System.out.println("max: "+list.stream().sorted((a,b)->b-a).findFirst().get());//降序
        System.out.println("min: "+list.stream().sorted((a,b)->a-b).findFirst().get());//升序

        System.out.println(list.stream().distinct().collect(Collectors.toList()));

        Stream.iterate(1,x->x+1).limit(50).skip(19).limit(11).forEach(System.out::println);

        Stream.of("one", "two", "three", "four") .filter(e -> e.length() > 3) .peek(e -> System.out.println("Filtered value: " + e)) .map(String::toUpperCase) .peek(e -> System.out.println("Mapped value: " + e)) .collect(Collectors.toList());

        list.stream().peek(e-> System.out.print(e+" ")).collect(Collectors.toList());

    }
}
