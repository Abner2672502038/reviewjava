package com.hrbust.oop;

/**
 * @program: reviewJava
 * @description:
 * @author: Abner
 * @create: 2020-04-01 09:48
 */
public class TestInterface implements InterfaceA {
    public static void main(String[] args) {
        InterfaceA interfaceA = new TestInterface();
        interfaceA.methodA();
        interfaceA.methodB();
        interfaceA.methodD();
        System.out.println(InterfaceA.age);
        InterfaceA.methodC();
    }
    @Override
    public void methodA() {
        System.out.println("A的抽象方法");
    }

    @Override
    public void methodB() {
        System.out.println("默认方法");

    }

    @Override
    public void methodD() {
        System.out.println("B的抽象方法");
    }
}
