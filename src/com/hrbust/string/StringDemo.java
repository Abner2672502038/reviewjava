package com.hrbust.string;


import jdk.nashorn.internal.runtime.regexp.RegExp;
import jdk.nashorn.internal.runtime.regexp.RegExpMatcher;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @program: reviewJava
 * @description:
 * @author: Abner
 * @create: 2020-03-26 15:38
 */
public class StringDemo {
    public static void main(String[] args) {
        /**
         * 1.String :字符串使用""表示
         * 2.String声明为final不可被继承
         * 3.String实现了java.io.Serializable接口可以序列化
         *       实现了Comparable<String>接口 可以比较大小
         * 4.String内部定义了一个final char[] value用于存储字符串数据
         * 5.String是一个不可变字符序列
         *   体现:1.对字符串重新赋值时,需要指定重新的内存区域赋值,不能在原有的value进行赋值
         *       2.当随现有的字符串连接操作时,也需要指定重新的内存区域赋值,不能在原有的value进行赋值
         *       3.当调用Strig的replace()方法修改字符串时,也需要指定重新的内存区域赋值,不能在原有的value进行赋值
         *6.通过字面量方法赋值,此时字符串值声明在字符串常量池中
         * 字符串常量池中不会存储相同的值
         */
       // test1();
        //test2();
      //  test4();
       //test5();
        //test6();
        //test7();
       // test8();
        test9();
    }
    public static void test1() {
        String s1 = "abc";//字面量
        String s2 = "abc";
        System.out.println(s1 == s2);//true表示内存中指向同一块地址
        s1 = "java";
        System.out.println(s1);//java
        System.out.println(s2);//abc
        System.out.println("-------------");
        String s3 = "java";
        String s4 = s1.replace('j', 'g');
        System.out.println(s3);
        System.out.println(s4);
    }

    /**
     * 1.通过字面量
     * 2.通过new+构造器
     *
     */
    public static void test2() {
        //String  s1="abc";与String s2=new String();
        //通过字面量在字符串常量池中
        String s1 = "javase";
        String s2 = "javase";
        //在堆空间
        String s3 = new String("javase");
        String s4 = new String("javase");
        System.out.println(s1 == s2);
        System.out.println(s3 == s4);
        //new+构造器的方式中属性value指向字符串常量池中的javase

        Person person = new Person("Tom", 12);
        Person person1 = new Person("Tom", 12);
        System.out.println(person.name=person1.name);
        person.name = "ert";
        System.out.println(person1.name);
        //用String string=new Sting("abc");创建了几个对象?
        //2个,一个是在new出来的,一个char[]的对象在常量池
    }
    public static void test4() {
        /**
         * 常量与常量的拼接在常量池中,常量池中无重复
         *只要有一个变量,结果就在堆中
         * 调用intern()方法时,返回常量池中的结果
         */
        String s1 = "java";
        String s2 = "netty";
        String s3 = "javanetty";
        String s4 = "java" + "netty";
        String s5 = "java" + s2;
        String s6 = s1 + "netty";
        String s7 = s1 + s2;
        System.out.println(s3 == s4);
        System.out.println(s3 == s5);
        System.out.println(s3 == s6);
        System.out.println(s3 == s7);
        System.out.println(s5 == s6);
        System.out.println(s5 == s7);
        System.out.println(s6 == s7);
        String s8 = s5.intern();//返回值是从常量池的地址
        System.out.println(s3==s8);
    }

    /**
     * String的常见的方法
     */
    public static void test5() {
        String s1 = "HelloWorld";
        System.out.println(s1.length());//返回字符串的长度
        System.out.println(s1.charAt(1));//返回索引处的字符
        System.out.println(s1.isEmpty());//判断字符串内容有木有
        String s2 = s1.toUpperCase();//转换成大写
        System.out.println(s1);//s1是不可变的
        System.out.println(s2);
        System.out.println("-----------------");
        String s3 = "   Hello   World ";
        String s4 = s3.trim();//去除字符串的前导和后导空白
        System.out.println(s3);
        System.out.println(s4);
        System.out.println("---------------");
        String s5 = "helloworld";
        System.out.println(s1.equals(s5));
        System.out.println(s1.equalsIgnoreCase(s5));//忽略大小写
        System.out.println("----------------");
        String s6 = "abc";
        System.out.println(s6.concat("def"));//用于字符串的拼接
        System.out.println("---------------------");
        String s7 = "abc";
        String s8 = "abd";
        System.out.println(s7.compareTo(s8));//比较字符串的比较,字符串的排序,c-d=-1
        System.out.println("-------------------------");
        String s9 = "哈尔滨理工大学";
        String s10 = s9.substring(3);//返回从第3个索引位置导最后的字符串,包含3处字符
        String s11 = s9.substring(3, 5);//左闭右开[3,5)
        System.out.println(s9);
        System.out.println(s10);
        System.out.println(s11);

    }
    public static void test6() {
        String s1 = "HeloloWorld";
        boolean b = s1.endsWith("rld");//是否以指定后缀结束
        System.out.println(b);
        boolean b2 = s1.startsWith("He");//是否以指定前缀开始
        System.out.println(b2);
        boolean b3 = s1.startsWith("ll", 2);//是否以指定字符从索引处开始
        System.out.println(b3);
        System.out.println("----------------");
        String s2 = "lo";
        boolean b4 = s1.contains(s2);//s1是否包含s2
        System.out.println(b4);
        System.out.println(s1.indexOf("lo"));//返回字符串首次在此字符串中的第一次索引位置,不存在返回-1
        System.out.println(s1.indexOf("lo", 4));//从所应位置开始往后找字符串的第一次出现的位置,应用于字符串在此字符串中出现的次数
        System.out.println("--------------------");
        System.out.println(s1.lastIndexOf("lo"));//从后往前找
        System.out.println(s1.lastIndexOf("lo", 2));//从索引位置从后往前找
        //什么情况下indexof()与lastindexof()找到的索引一致
        //只有一个或者找不到

    }
    public static void test7() {
        String s1 = "哈尔滨理工哈大学";
        String s2 = s1.replace('哈', '虾');
        System.out.println(s1);
        System.out.println(s2);
        System.out.println("----------");
        String s3 = s1.replace("哈尔滨", "北京");
        System.out.println(s3);
        System.out.println("--------------------------");
        String s4 = "123hello88world99";
        System.out.println(s4.replaceAll("\\d+", ",").replaceAll("^,|,$", ""));
        System.out.println("--------------");
        String s5 = "18846756637";
        System.out.println(s5.matches("\\d+"));//匹配满足正则表达式不

        System.out.println("------------------");
        String s6 = "hello|world|hrbust";
        String[] split = s6.split("\\|");//切片,用正则表达式分割
        for (String s : split) {
            System.out.println(s);
        }
    }

    /**
     * 字符串得查找次数
     */
    public static void test8() {
        String s1 = "哈尔滨理工大学理工北京哈哈夫人不能回国理工,对方是否关闭ahsdsfgbtrg理工";
        int i=0;
        int count = 0;
        while (true) {

            int index = s1.indexOf("理工", i);
            if (index == -1) {
                break;
            }
            i = i + index + 2;
            count++;
        }
        System.out.println(count);
        for (int j = 1; j < 1; j++) {
            System.out.println("q");
        }
    }
    public static void test9() {
        /*String s1 = "哈尔滨理工666大学";
        String s2 = s1.replaceAll("\\d+", "");
        System.out.println(s2);*/
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
       // boolean matches = next.matches("[1-9]{1}\\d{4,14}");
        boolean matches = next.matches("^(13|18)\\d{9}");

        if (matches) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }


}
