package com.gk.base;

/**
 * @author goodking
 * @data 2022-03-20 12:15
 */
public class demo2 {

    static int n = 0;

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                n++;
            }
        };

        Thread thread = new Thread(runnable);

        thread.start();
        System.out.println(n);

    }
}

class ThreadTest1 implements Runnable {

    @Override
    public void run() {

    }
}