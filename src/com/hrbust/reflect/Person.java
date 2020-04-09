package com.hrbust.reflect;

import com.hrbust.annotation.MyAnnotation;

import java.io.Serializable;

/**
 * @program: reviewJava
 * @description:
 * @author: Abner
 * @create: 2020-03-11 18:40
 */
public class Person extends Creature<String> implements Serializable {
    public String name;
    int id;
    private int age;

    public Person() {
    }

    public Person(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    private Person(String name, int id) {
        this.name = name;
        this.id = id;
    }
    public static void show() {
        System.out.println("哈哈哈");
    }
     @MyAnnotation
    private int display(int id) {
        return id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }
}
