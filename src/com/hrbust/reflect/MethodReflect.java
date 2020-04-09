package com.hrbust.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

/**
 * @program: reviewJava
 * @description: 方法反射
 * @author: Abner
 * @create: 2020-03-12 11:18
 */
public class MethodReflect {
    public static void main(String[] args) throws Exception {
        Class<Person> clazz = (Class<Person>) Class.forName("com.hrbust.reflect.Person");
        //获取当前运行时类和其父类中声明为public的方法
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println();
        //获取当前运行时类中的所有方法
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method method : declaredMethods) {
            //获取方法上的注解
            Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
            for (Annotation declaredAnnotation : declaredAnnotations) {
                System.out.println(declaredAnnotation.toString());
            }
            //获取访问修饰符
            int modifiers = method.getModifiers();
            System.out.print(Modifier.toString(modifiers) + "\t");
            //获取返回值
            Class<?> returnType = method.getReturnType();
            System.out.print(returnType.getName()+"\t");
            //获取方法名
            String name = method.getName();
            System.out.print(name);
            //获取参数列表
            System.out.print("(");
            Parameter[] parameters = method.getParameters();
            if (!(parameters != null && parameters.length == 0)) {
                for (int i = 0; i < parameters.length; i++) {
                    if (i == parameters.length - 1) {
                        System.out.print(parameters[i].getType());
                        break;
                    }
                    System.out.print(parameters[i].getType() + ",");
                }
            }
            System.out.println(")");

        }
    }

}
