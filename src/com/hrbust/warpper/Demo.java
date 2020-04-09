package com.hrbust.warpper;

/**
 * @program: reviewJava
 * @description:
 * @author: Abner
 * @create: 2020-04-09 10:18
 */
public class Demo {
    public static void main(String[] args) {
                /**
                 * Integer
                 *
                 */
        System.out.println(Integer.bitCount(8));//获取补码的非0数
        Integer integer1 = Integer.valueOf(6);//装箱
        int i = integer1.intValue();//拆箱
        int i1 = Integer.parseInt("34");//字符串转换int
        Integer integer2 = 123;
        Integer integer3 = 123;
        //常量池:整数:-128~127,字符型:0~127
        System.out.println(integer2 == integer3);//true
        Integer integer4 = 128;
        Integer integer5 = 128;
        System.out.println(integer4==integer5);//false


    }
}
