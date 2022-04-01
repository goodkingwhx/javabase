package com.gk.lambda.lambda;

import com.gk.lambda.why.Student;

import java.util.concurrent.Callable;

import static sun.misc.PostVMInitHook.run;

/**
 * @author goodking
 * @data 2022-03-16 16:32
 */
public class LambdaTest {
    public static void main(String[] args) throws Exception {
        /*Runnable runnable = new Runnable(){
            @Override
            public void run() {
                System.out.println("running1....");
            }
        };
        runnable.run();

        Runnable runnable1 = ()->{
            System.out.println("running2...");
        };
        runnable1.run();

        Runnable runnable2 = ()-> System.out.println("running3...");
        runnable2.run();*/


        System.out.println("===========================================");

        Callable c1 = new Callable() {
            @Override
            public String call() throws Exception {
                return "gk";
            }
        };

        System.out.println(c1.call());

        Callable c2 = ()-> {return "gk2";};
        System.out.println(c2.call());

        Callable c3 = ()-> "gk3";
        System.out.println(c3.call());

        System.out.println("=====================================");

        StudentDao sd1 = new StudentDao() {
            @Override
            public void insert(Student student) {
                System.out.println("insert student1");
            }
        };

        StudentDao sd2 = (student)-> System.out.println("student:"+student);
        StudentDao sd3 = (Student student)-> System.out.println(student);
        sd1.insert(new Student());
        sd2.insert(new Student());
        sd3.insert(new Student());

        System.out.println("=========================================");

        TeacherDao td1 = (teacher)->1;
        TeacherDao td2 = (teacher)->{return 2;};
        TeacherDao td3 = (Teacher teacher)->3;
        TeacherDao td4 = (Teacher teacher)->{return 4;};
        System.out.println(td1.get(new Teacher()));
        System.out.println(td2.get(new Teacher()));
        System.out.println(td3.get(new Teacher()));
        System.out.println(td4.get(new Teacher()));
        System.out.println("=================================");

        Runnable runnable = ()->{int i = exec();
            System.out.println(i);};

        runnable.run();

    }

    static int exec() {
        return 1;
    }
}
