package com.hrbust.annotation;

import java.lang.annotation.*;

@Repeatable(MyAnnotations.class)//jdk8之后的可重复注解
@Documented
@Inherited//使用该注解的注解的类的子类继承此注解
//JDK8之后引入了类型注解,可注解泛型,方法中的参数等ElementType.TYPE_PARAMETER,ElementType.TYPE_USE
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    String[] value() default "harbin";
}
