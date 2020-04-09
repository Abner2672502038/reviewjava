package com.hrbust.reflect;

import java.lang.annotation.Annotation;

/**
 * @program: reviewJava
 * @description: 获取运行时类的注解, 包, 接口的反射
 * @author: Abner
 * @create: 2020-03-12 15:13
 */
public class AnnotationAndPackageReflect {
    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = AnnotationAndPackageReflect.class.getClassLoader();
        Class<Person> clazz = (Class<Person>) classLoader.loadClass("com.hrbust.reflect.Person");
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
        Package aPackage = clazz.getPackage();
        System.out.println(aPackage);
        Class<?>[] interfaces = clazz.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface);

        }
    }
}
