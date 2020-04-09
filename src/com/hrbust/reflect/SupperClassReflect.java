package com.hrbust.reflect;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @program: reviewJava
 * @description: 父类及父类的泛型
 * @author: Abner
 * @create: 2020-03-12 15:20
 */
public class SupperClassReflect {
    public static void main(String[] args) {
        //获取其父类
        Class<Person> personClass = Person.class;
        Class<? super Person> superclass = personClass.getSuperclass();
        System.out.println(superclass);
        //获取其运行时类继承父类的泛型
        Type genericSuperclass = personClass.getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        Type[] typeArguments = parameterizedType.getActualTypeArguments();
        for (Type typeArgument : typeArguments) {
            System.out.  println(typeArgument.getTypeName());
        }
    }
}
