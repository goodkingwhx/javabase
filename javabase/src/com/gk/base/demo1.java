package com.gk.base;

import java.util.ArrayList;
import java.util.Vector;

/**
 * @author goodking
 * @data 2022-02-02 9:15
 */
public class demo1 {
    public static void main(String[] args) {
        //位运算符：只能操作数值，操作的时候会转成二进制进行运算
        System.out.println(4&5);
        System.out.println(4|5);
        System.out.println(4^5);

        int b = 2;
        System.out.println(++b+b++);

        System.out.println(b);

        int arr[] = {20,12,1};
        System.out.println("数组长度： "+arr.length);
        double darr[] = {};
        int length = darr.length;
        System.out.println(length);

        ArrayList arrayList = new ArrayList();
        arrayList.add("1");
        arrayList.add("2");
        System.out.println("arraylist的大小： "+arrayList.size());
        System.out.println(arrayList.size()+(arrayList.size()>>1));//arraylist每次扩容是原来的1.5倍 可以查看grow()
        System.out.println(2>>1);

    }
}
