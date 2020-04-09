package com.hrbust.reflect;

import sun.rmi.transport.tcp.TCPTransport;

import java.lang.reflect.Method;

/**
 * @program: reviewJava
 * @description: 获取当前运行时类的指定的方法
 * @author: Abner
 * @create: 2020-03-12 16:54
 */
public class GetMethodByAssign {
    public static void main(String[] args) throws Exception {
        //获取非静态的方法
        Class<Person> personClass = Person.class;
        Person person = personClass.newInstance();
        Method display = personClass.getDeclaredMethod("display", int.class);
        //设置可访问
        display.setAccessible(true);
        //invoke的返回值为调用方法的返回值
        int invoke = (int) display.invoke(person, 10);
        System.out.println(invoke);
        //获取静态方法
        Method show = personClass.getDeclaredMethod("show");
        show.setAccessible(true);
        show.invoke(personClass);

    }
}
