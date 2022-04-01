package com.gk.lambda.why;

import java.util.ArrayList;

/**
 * @author goodking
 * @data 2022-03-16 16:05
 */
public class Test {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<Student>();
        list.add(new Student("zhangsan",14,67));
        list.add(new Student("lisi",13,89));
        list.add(new Student("wangwu",15,97));
        list.add(new Student("maliu",12,63));
        list.add(new Student("zhaoqi",17,75));

        findByAge(list);
        System.out.println("====================================");
        findByScore(list);
    }

    public static void findByAge(ArrayList<Student> students) {
        ArrayList<Student> list = new ArrayList<>();
        for (Student student : students) {
            if (student.getAge()>14) {
                list.add(student);
            }
        }

        for (Student student : list) {
            System.out.println(student);
        }
    }

    public static void findByScore(ArrayList<Student> students) {
        ArrayList<Student> list = new ArrayList<>();
        for (Student student : students) {
            if (student.getScore()>75) {
                list.add(student);
            }
        }

        for (Student student : list) {
            System.out.println(student);
        }
    }
}
