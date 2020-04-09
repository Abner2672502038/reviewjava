package com.hrbust.oop;

/**
 * @program: reviewJava
 * @description:
 * @author: Abner
 * @create: 2020-04-01 09:52
 */
public abstract class AbstractClass {
    int age;

    public AbstractClass(int age) {
        this.age = age;
    }

    abstract void method();
    void methodA() {
        System.out.println("A方法");
    }
}
