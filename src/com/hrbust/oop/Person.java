package com.hrbust.oop;

import java.util.Date;

/**
 * @program: reviewJava
 * @description:
 * @author: Abner
 * @create: 2020-04-01 08:46
 */
public class Person {
    String name;
    int age;
    Date birth;

    public Person() {
    }

    public Person(String name, int age, Date birth) {
        this.name = name;
        this.age = age;
        this.birth = birth;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    protected String show() {
        return name + birth;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birth=" + birth +
                '}';
    }
}
