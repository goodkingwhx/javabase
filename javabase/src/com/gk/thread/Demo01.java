package com.gk.thread;

/**
 * @author goodking
 * @data 2022-03-21 9:03
 */
public class Demo01 {

    public static void main(String[] args) {
        SingletonTest instance = SingletonTest.getInstance();
        SingletonTest instance1 = SingletonTest.getInstance();
        System.out.println(instance == instance1);
    }
}


class SingletonTest {
    private static SingletonTest INSTANCE;

    public static synchronized SingletonTest getInstance() {
        if (INSTANCE==null) {
            INSTANCE = new SingletonTest();
        }
        return INSTANCE;
    }
}

class Test extends Base{

    static{
        System.out.println("test static");
    }

    public Test(){
        System.out.println("test constructor");
    }

    public static void main(String[] args) {
        new Test();
    }
}

class Base{

    static{
        System.out.println("base static");
    }

    public Base(){
        System.out.println("base constructor");
    }
}