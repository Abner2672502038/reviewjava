package com.hrbust.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;

/**
 * @program: reviewJava
 * @description: 反射获得构造器
 * @author: Abner
 * @create: 2020-03-12 15:08
 */
public class ConstructorReflect {
    public static void main(String[] args) throws Exception {
        Class<Person> personClass = Person.class;
        //获取自己类声明为public的构造器
        Constructor<?>[] constructor = personClass.getConstructors();
        for (Constructor<?> constructor1 : constructor) {
            System.out.println(constructor1);
        }
        System.out.println();
        //获取当前运行时类的所有构造器
        Constructor<?>[] declaredConstructors = personClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            //获取构造器参数
            Parameter[] parameters = declaredConstructor.getParameters();
            //与前面一致
        }

    }
}
