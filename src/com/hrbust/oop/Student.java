package com.hrbust.oop;

import java.util.Date;

/**
 * @program: reviewJava
 * @description:
 * @author: Abner
 * @create: 2020-04-01 08:47
 */
public class Student extends Person {

    String school;

    public Student(String name, int age, Date birth, String school) {
        super(name, age, birth);
        this.school = school;
    }

    public Student(String school) {
        //隐式调用了父类的无参构造方法
        this.school = school;
    }

    @Override
    //重写的方法:
    // 1.比原来的方法的访问级别更高或者一样
    // 2.不能比原来的方法抛出更多的异常
    /**
     * 多态的前提:
     * 1.继承
     * 2.覆盖:子类覆盖父类的方法
     * 3.声明的父类的类型,实例的是子类的类型
     * 注:向上转型,向下转型(强转),必须是同一个继承树
     */
    public String show() {
        return name + birth;
    }
}
