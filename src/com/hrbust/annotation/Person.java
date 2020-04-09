package com.hrbust.annotation;

/**
 * @program: reviewJava
 * @description:
 * @author: Abner
 * @create: 2020-03-11 16:50
 */
interface Info {
    void show();
}
//JDK8之后
@MyAnnotation
@MyAnnotation("Beijing")
/**jdk8之前
@MyAnnotations({@MyAnnotation({"北京", "天津"}),@MyAnnotation})*/
public class Person<@MyAnnotation("lanzhou") Object> implements Info{
    private String name;
    private String age;

    public Person() {
    }

    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void show() {
        System.out.println("你好");
    }
}
