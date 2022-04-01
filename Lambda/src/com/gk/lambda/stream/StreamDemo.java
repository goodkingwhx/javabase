package com.gk.lambda.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author goodking
 * @data 2022-03-16 18:07
 */
public class StreamDemo {
    static void gen1() {
        String[] strs = {"a","b","c","d"};
        Stream<String> strs1 = Stream.of(strs);
        strs1.forEach(System.out::println);
    }

    public static void main(String[] args) {
        //gen1();



        //中间操作
        Arrays.asList(1,2,3,4,5,6,7,8,9).stream().filter((x)->x%2==0).forEach(System.out::println);

        //求和
        int sum = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9).stream().filter(x -> x % 2 == 0).mapToInt(x -> x).sum();
        System.out.println(sum);
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        //求最大值
        Optional<Integer> max = list.stream().max((a, b) -> a - b);
        System.out.println("求最大值："+max.get());

        Optional<Integer> min = list.stream().min((a, b) -> a - b);
        System.out.println("最小值："+min.get());

        Optional<Integer> mint = list.stream().min((a, b) -> {return a - b;});
        System.out.println("最小值："+min.get());

        System.out.println("================================");
        Optional<Integer> any = list.stream().filter(x -> x % 2 == 0).findAny();
        System.out.println(any.get());

        System.out.println(list.stream().filter(x->x%10 == 6).findFirst().get());

        Stream<Integer> integerStream = list.stream().filter(i -> {
            System.out.println("运行代码");
            return i % 2 == 0;
        });
        System.out.println(integerStream.findAny().get());

        System.out.println("==============================");
        //使用max min去除最大和最小值
        Optional<Integer> min1 = list.stream().sorted().findFirst();
        System.out.println("min: " + min1.get());
        Integer integer = list.stream().sorted((a,b)->b-a).findFirst().get();
        System.out.println("max: " + integer);


        Arrays.asList("java","c","scala","python","oc","jeva").stream().sorted().forEach(System.out::println);
        Arrays.asList("java","c","scala","python","oc","jeva").stream().sorted((a,b)->a.length()-b.length()).forEach(System.out::println);

        ArrayList<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("b");
        strings.add("c");
        strings.add("d");
        strings.add("e");

        //转换为大写
        List<String> collect = strings.stream().map(String::toUpperCase).collect(Collectors.toList());
        collect.forEach(System.out::println);

        System.out.println("================================");
        //过滤元素并返回一个集合对象
        List<Integer> collect1 = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        collect1.forEach(System.out::println);

        //去重操作
        List<Integer> collect2 = Arrays.asList(1, 2, 3, 3, 3, 4, 5, 3, 2).stream().distinct().collect(Collectors.toList());
        collect2.forEach(System.out::print);
        System.out.println();
        Arrays.asList(1, 2, 3, 3, 3, 4, 5, 3, 2).stream().collect(Collectors.toSet()).forEach(System.out::print);

        System.out.println("==============打印20-30==============");
        //打印20-30
        Stream.iterate(1,x->x+1).limit(50).skip(19).limit(11).forEach(System.out::print);
        System.out.println();
        String str = "12,34,22,66,7,1";
        String[] split = str.split(",");
        ArrayList<Integer> list1 = new ArrayList<>();
        for (String s : split) {
            list1.add(Integer.valueOf(s));
        }
        int sum2 = 0;
        for (int i = 0; i < list1.size(); i++) {
            sum2 +=list1.get(i);
        }
        System.out.println("===============str==================: "+sum2);
        list1.stream().forEach(System.out::print);
        System.out.println("===============str==================: ");
        int sum1 = Stream.of(str.split(",")).mapToInt(x -> Integer.valueOf(x)).sum();
        System.out.println(sum1);

        //创建一组自定义对象
        String str2 = "java,scala,python";
        Stream.of(str2.split(",")).map(x->new Person(x)).forEach(System.out::println);
        Stream.of(str2.split(",")).map(Person::new).forEach(System.out::println);
        Stream.of(str2.split(",")).map(x->Person.build(x)).forEach(System.out::println);
        Stream.of(str2.split(",")).map(Person::build).forEach(System.out::println);

        //str中的每一个数值都打印出来，同事算出最终的求和结果
        System.out.println(Stream.of(str.split(",")).peek(System.out::println).mapToInt(Integer::valueOf).sum());
    }
}
