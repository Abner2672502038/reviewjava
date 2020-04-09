package com.hrbust.stack;

/**
 * @program: reviewJava
 * @description:操作数栈
 * @author: Abner
 * @create: 2020-04-02 18:38
 */
public class OperatorStack {
    public static void main(String[] args) {
        test();
    }
    public int getSum() {
        byte i = 10;
        int j = 8;
        int k = i + j;
        return k;
    }

    public void testGetSum() {
        int sum = getSum();
        int i = sum++;
    }

    public static void test() {
        //第一类
        int i1 = 10;
        i1++;
        System.out.println(i1);//11
        int i2 = 10;
        ++i2;
        System.out.println(i2);//11
        //第二类
        int i3 = 10;
        int i4 = i3++;
        System.out.println(i4);//10
        int i5 = 10;
        int i6 = ++i5;
        System.out.println(i6);//11
        //第三类
        int i7 = 10;
        i7 = i7++;
        System.out.println(i7);//10
        int i8 = 10;
        i8 = ++i8;
        System.out.println(i8);//11
        //第四类
        int i9 = 10;
        int i10 = i9++ + ++i9;
        System.out.println(i10);//22

    }
}
