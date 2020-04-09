package com.hrbust.stack;

import java.util.Date;

/**
 * @program: reviewJava
 * @description: 局部变量表
 * @author: Abner
 * @create: 2020-04-01 19:37
 */

/**
 * 局部变量表中的单元式slot(变量槽),32位(引用数据类型)的一个槽,64位(long,double)的2个槽
 */

/**
 * 成员变量:使用前,会默认初始化赋值
 *        类变量:在Linking->prepare阶段默认初始化赋值;在initial阶段会显示赋值
 *
 *        实例变量:随着对象的创建,会在堆空间中分配空间,并默认赋值
 * 局部变量:使用前,用进行初始化
 * 局部变量表中的变量也是垃圾回收的根节点,局部变量表中直接或者间接引用的变对象不会被垃圾回收
 */
public class LocalVariablesClass {
    public static void main(String[] args) {

    }
    public static int testJclasslib() {
        LocalVariablesClass localVariablesClass = new LocalVariablesClass();
        Date date = new Date();
        int num = 19;
        System.out.println(date.toString());
        return num;
    }
    public void test1() {
        int num = 10;
        String s = new String();
    }

    /**
     * slot重复使用
     */
    public void test2() {
        int a = 10;
        {
            int b = a++;
            a += b;

        }

        //此时c在局部变量表中的卡槽式已经销毁变量b的卡槽
        int c = a++;
    }

}
