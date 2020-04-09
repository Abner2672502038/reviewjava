package com.hrbust.newjava8.optional;

import com.hrbust.newjava8.stream.StreamDemo;

/**
 * @program: reviewJava
 * @description: 男孩
 * @author: Abner
 * @create: 2020-03-15 14:40
 */
public class Boy {
    private String name;
    private int age;

    public Boy() {
    }

    public Boy(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
