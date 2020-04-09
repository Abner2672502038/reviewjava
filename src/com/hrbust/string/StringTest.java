package com.hrbust.string;


/**
 * @program: reviewJava
 * @description:
 * @author: Abner
 * @create: 2020-03-26 16:43
 */
public class StringTest {
    public static void main(String[] args) {
        StringTest stringTest = new StringTest();
        stringTest.change(stringTest.str, stringTest.ch);
        System.out.println(stringTest.str);
        System.out.println(stringTest.ch);
    }

    String str = new String("good");
    char[] ch = {'t', 'e', 's', 't'};
    public void change(String str, char[] ch) {
        str = "testjava";//good,表现了String的不可变性,传递地址重新整一个内存
        ch[0] = 'b';//best
    }
}
