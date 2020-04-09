package com.hrbust.stack;

/**
 * @program: reviewJava
 * @description:早期绑定(invokespecial)和晚期绑定(invokevirtual):是符号引用转为直接引用的方式
 * 早期绑定:编译期可以确定
 * 晚期:编译期不可绑定
 * @author: Abner
 * @create: 2020-04-02 22:28
 */
public class InvokeMethod {
    public static void main(String[] args) {

    }

    class Animal {
        public void eat() {
            System.out.println("动物吃东西");
        }
    }

    interface Hunt {
        void hunt();
    }

    class Dog extends Animal implements Hunt {
        public Dog() {
            //此时为早期绑定
            super();
        }
        @Override

        public void eat() {
            System.out.println("狗吃东西");
        }

        @Override
        public void hunt() {
            System.out.println("狗吃耗子,多管闲事");
        }
    }

    class Cat extends Animal implements Hunt {
        @Override
        public void eat() {
            System.out.println("猫吃东西");
        }

        @Override
        public void hunt() {
            System.out.println("猫吃耗子");
        }
    }

    //此时是晚期绑定invokevirtual
    public void TestEat(Animal animal) {
        animal.eat();
    }

    //此时晚期绑定
    public void TestHunt(Hunt hunt) {
        hunt.hunt();
    }
}
