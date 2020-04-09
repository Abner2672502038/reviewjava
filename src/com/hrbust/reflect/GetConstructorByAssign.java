package com.hrbust.reflect;

import java.lang.reflect.Constructor;

/**
 * @program: reviewJava
 * @description: 获取运行时类指定的构造方法
 * @author: Abner
 * @create: 2020-03-12 17:00
 */
public class GetConstructorByAssign {
    public static void main(String[] args) throws Exception {
        //获取Class对象
        Class<Person> personClass = Person.class;
        //获取构造器
        Constructor<Person> declaredConstructor = personClass.getDeclaredConstructor(String.class, int.class);
        //设置可访问
        declaredConstructor.setAccessible(true);
        //创建对象
        Person abner = declaredConstructor.newInstance("abner", 10);
        System.out.println(abner);
    }
}
