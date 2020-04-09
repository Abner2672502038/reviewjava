package com.hrbust.stack;

/**
 * @program: reviewJava
 * @description: 局部变量的线程安全性
 * @author: Abner
 * @create: 2020-04-04 10:43
 */

/**
 * 局部变量的线程安全:若只有一个线程访问,则绝对安全
 *    多个线程访问此数据,此数据为共享数据时,还没有同步控制时,线程不安全
 *
 */
public class ThreadSafe {
    //线程安全
    public static void method1() {
        //StringBuilder:线程不安全
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("a");
    }

    //线程不安全
    public static void method2(StringBuilder s1) {
        s1.append("a");
    }

    //线程不安全
    public static StringBuilder method3() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("a");
        return stringBuilder;
    }

    //线程安全
    public static String method4() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("a");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        StringBuilder s1 = new StringBuilder();
        new Thread(()->{
            s1.append("a");});
        method2(s1);//线程不安全
    }
}
