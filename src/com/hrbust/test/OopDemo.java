package com.hrbust.test;

import com.hrbust.oop.Test;

/**
 * @program: reviewJava
 * @description:
 * @author: Abner
 * @create: 2020-03-28 11:08
 */
public class OopDemo extends Test {
    public static void main(String[] args) {
        OopDemo oopDemo = new OopDemo();
        System.out.println(oopDemo.show());
    }
    public int show1() {
        return show();
    }
}
