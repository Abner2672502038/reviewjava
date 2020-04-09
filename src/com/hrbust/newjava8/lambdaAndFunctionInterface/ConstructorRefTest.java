package com.hrbust.newjava8.lambdaAndFunctionInterface;


import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 一、构造器引用
 * <p>
 * 二、数组引用
 * <p>
 * <p>
 * Created by shkstart
 */
public class ConstructorRefTest {
    public static void main(String[] args) {
        //test1();
       //test2();
        test4();

    }
    //构造器引用
    //Supplier中的T get()

    public static void test1() {
        Supplier<String> supplier = String::new;
        Integer s = supplier.get().length();
        System.out.println(s);
    }

    //Function中的R apply(T t)
    public static void test2() {
        Function<String, String> function = String::new;
        String host = function.apply("host");
        System.out.println(host);

    }

    //BiFunction中的R apply(T t,U u)

    public void test3() {

    }

    //数组引用
    //Function中的R apply(T t)

    public static void test4() {
        Function<Integer, int[]> function = int[]::new;
        int[] apply = function.apply(10);
        System.out.println(Arrays.toString(apply));

    }
}
