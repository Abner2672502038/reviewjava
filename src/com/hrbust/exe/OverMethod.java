package com.hrbust.exe;

import java.util.Arrays;
import java.util.Date;

/**
 * @program: reviewJava
 * @description:
 * @author: Abner
 * @create: 2020-04-02 15:33
 */
public class OverMethod {
    public static void main(String[] args) {
        testArrays();

    }

    public void test() {
        int num = 10;
        Date date = new Date();
        System.out.println(date.toString());
    }

    public int test(Date date) {
        System.out.println(date.toString());
        return 0;
    }

    public void testArray(int[] arr) {
        for (int i : arr) {
            System.out.println(i);
        }
        arr[0] = 666;
        //变化后
        for (int i : arr) {
            System.out.println(i);
        }
    }
    public char[] returnArray() {
        String str = "哈尔滨理工大学";
        return str.toCharArray();
    }

    public static void testArrays() {
        int[] arr = {4, 2, 36, 1, 68, 23, 66};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        String[] str = {"A", "N", "D", "P"};
        System.out.println(Arrays.binarySearch(str, "D"));
        String[] clone = str.clone();
        System.out.println(Arrays.toString(clone));

    }
}
