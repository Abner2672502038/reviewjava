package com.hrbust.oop;

/**
 * @program: reviewJava
 * @description:访问修饰符
 * @author: Abner
 * @create: 2020-03-28 11:06
 */
public class Test {
    protected int id;
    public Test() {

    }

    public Test(int id) {
        this.id = id;
    }
    protected int show() {
        return id;
    }
}
