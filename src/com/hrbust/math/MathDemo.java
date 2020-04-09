package com.hrbust.math;

/**
 * @program: reviewJava
 * @description:
 * @author: Abner
 * @create: 2020-03-26 17:56
 */
public class MathDemo {


    public static void main(String[] args) {
        //取整
        double d1 = 6.6;
        long round = Math.round(d1);//四舍五入
        System.out.println(round);
        double ceil = Math.ceil(d1);//向上取
        System.out.println(ceil);
        double floor = Math.floor(d1);
        System.out.println(floor);//向下取
        System.out.println("---------------");
        //求最大最小
        int max = Math.max(3, 4);
        System.out.println(max);
        System.out.println("--------------------");
        //随机数
        double v = Math.random() * 10;
        System.out.println(v);
        System.out.println("-----------------------");
        //三角函数
        System.out.println(Math.sin(Math.PI / 2));
        System.out.println(Math.toRadians(45));//角度转弧度
        System.out.println("-----------------");
        //科学计算
        double pow = Math.pow(2, 2);//指数
        System.out.println(pow);
        System.out.println(Math.abs(-3));//绝对值

    }

}
