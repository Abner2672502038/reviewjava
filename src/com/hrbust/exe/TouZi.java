package com.hrbust.exe;

import java.util.Random;

/**
 * @program: reviewJava
 * @description: 骰子
 * @author: Abner
 * @create: 2020-03-27 16:54
 */
public class TouZi {
    public static void main(String[] args) {
        //test();
        test1();
    }

    /**
     * 生成骰子
     */
    public static void test() {
        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            int nextInt = random.nextInt(10);
            int temp = ((nextInt + 1) % 6) + 1;
            System.out.println(temp);
        }
    }

    /**
     * 1-100的质数
     */
    public static void test1() {
        for (int i = 1; i <= 100; i++) {
            if (judgePrimeNum(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean judgePrimeNum(int num) {
        if (num==1||num != 2 && num % 2 == 0) {
            return false;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
