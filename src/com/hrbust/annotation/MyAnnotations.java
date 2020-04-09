package com.hrbust.annotation;

import java.lang.annotation.*;

/**
 * 可重复注解
 */
@Documented
@Inherited//使用该注解的注解的类的子类继承此注解
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotations {

    MyAnnotation[] value();

}
