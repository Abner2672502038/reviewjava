package com.hrbust.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @program: reviewJava
 * @description:反射获取属性
 * @author: Abner
 * @create: 2020-03-11 18:42
 */
public class FieldReflect {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> person = Class.forName("com.hrbust.reflect.Person");
        //获取属性:获取到父类和自己中声明为public的属性
        Field[] fields = person.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println();
        //获取自己中的所有属性        //内部结构
        Field[] declaredFields = person.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            //修饰符
            int modifiers = declaredField.getModifiers();
            System.out.print(Modifier.toString(modifiers)+"\t");
            //获取数据类型
            Class<?> type = declaredField.getType();
            System.out.print(type.getName() + "\t");
            //获取变量名
            String name = declaredField.getName();
            System.out.println(name);
        }

    }
}
