package com.hrbust.warpper;

import java.util.Arrays;

/**
 * @program: reviewJava
 * @description:
 * @author: Abner
 * @create: 2020-04-09 11:21
 */
public class TestObjectArray {

    public static void main(String[] args) {
        AcessDemo[] acessDemos = new AcessDemo[2];
        acessDemos[0] = new AcessDemo(1, "HOST", "男", "哈理工");
        acessDemos[1] = new AcessDemo();
        System.out.println(Arrays.toString(acessDemos));
    }
}
