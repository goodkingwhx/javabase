package com.gk.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author goodking
 * @data 2022-02-03 20:43
 */
public class TestException {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            System.out.println("请输入被除数:");
            int num1 = in.nextInt();
            System.out.println("请输入除数：");
            int num2 = in.nextInt();
            System.out.println(String.format("%d/%d=%d",num1,num2,num1/num2));
        } catch (InputMismatchException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println("输入类型异常");
        } catch (ArithmeticException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println("数学异常，除数不能为0");
        }
        System.out.println("感谢使用本程序1");
    }
}
