package com.hrbust.stack;

/**
 * @program: reviewJava
 * @description: Java虚拟机栈
 * @author: Abner
 * @create: 2020-03-27 18:03
 */

/**
 * StackOverflowError
 * 默认状况下栈为:11405
 * Run->editConfiguration
 * 设置虚拟机栈后-Xss256k后:2452
 * 方法的结束有2种:正常结束return;出现未捕获处理异常,以抛出异常的方式结束
 *
 */
public class StackDemo {
    private static int count = 1;

    public static void main(String[] args) {
        System.out.println(count);
        count++;
        main(args);
    }
}
