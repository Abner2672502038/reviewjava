package com.hrbust.warpper;

import java.math.BigInteger;

/**
 * @program: reviewJava
 * @description:
 * @author: Abner
 * @create: 2020-04-09 10:46
 */
public class Test {
    public static void main(String[] args) {
        AcessDemo acessDemo = new AcessDemo(1, "HOST", "男", "哈理工");
        //public可访问,private不可访问
        System.out.println(acessDemo.name);
        System.out.println(acessDemo.id);
        String s = "lanzhou";
        method2(s);
        System.out.println(s);
        method(acessDemo);
        System.out.println(acessDemo.name);
        System.out.println(acessDemo.id);


    }

    public void getFobonani(int count) {
        BigInteger a = new BigInteger("1");
        BigInteger b = new BigInteger("1");
        BigInteger c;
        for (int i = 0; i < count; i++) {
            c = a.add(b);
            System.out.println(c);
            a = b;
            b = c;
        }
    }

    public static void method(AcessDemo acessDemo) {
        acessDemo.name = "abner";
        acessDemo.id = 34;
    }

    public static void method2(String s) {
        s = "hrbust";
    }

}
