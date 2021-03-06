package com.gk.lambda.why2;

import com.gk.lambda.why.Student;

import java.util.ArrayList;

/**
 * @author goodking
 * @data 2022-03-16 16:16
 */
public class Test {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<Student>();
        list.add(new Student("zhangsan",14,67));
        list.add(new Student("lisi",13,89));
        list.add(new Student("wangwu",15,97));
        list.add(new Student("maliu",12,63));
        list.add(new Student("zhaoqi",17,75));

        getByFilter(list,new AgeFilter());

        getByFilter(list,new ScoreFilter());


    }

    public static void getByFilter(ArrayList<Student> students,StudentFilter filter) {
        ArrayList<Student> list = new ArrayList<>();
        for (Student student : students) {
            if (filter.compare(student)) {
                list.add(student);
            }
        }
        printStudent(list);
    }

    public static void printStudent(ArrayList<Student> students) {
       students.forEach(System.out::println);
    }
}
