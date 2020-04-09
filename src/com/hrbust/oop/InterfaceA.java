package com.hrbust.oop;
//支持多继承
public interface InterfaceA extends InterfaceB, InterfaceC {
    int age = 12;

    void methodA();
//java8后引入默认方法
    default void methodB() {
        System.out.println("哈哈哈哈");
    }
    //静态方法
    static void  methodC() {
        System.out.println("嘟嘟嘟嘟嘟");
    }



}
