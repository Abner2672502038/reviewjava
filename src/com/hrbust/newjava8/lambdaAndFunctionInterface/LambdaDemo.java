package com.hrbust.newjava8.lambdaAndFunctionInterface;

import java.util.Comparator;
import java.util.function.*;

/**
 * @program: reviewJava
 * @description: lambda表达式
 * @author: Abner
 * @create: 2020-03-14 21:42
 */
public class LambdaDemo {
    public static void main(String[] args) {
       /* //以前的写法
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        int res = comparator.compare(23, 34);
        System.out.println(res);
        System.out.println();
        Comparator<Integer> comparator2 = (para1, para2) -> Integer.compare(para1, para2);
        System.out.println(comparator2.compare(34, 23));*/
        //test1();
        //test2();
        //test3();
        //test4();
        //test5();
       // test6();
        //test7();
        test8();

    }

    /**
     * ->lambda操作符
     * 左边:抽象方法的形参列表
     * 右边:抽象方法的具体实现
     */

    /**
     * 无参,无返回值
     */
    public static void test1() {
        Runnable runnable = () -> System.out.println("lambda表达式方式1");
        runnable.run();
    }

    /**
     * 需要一个参数,但无返回值
     */
    public static void test2() {
        //str的数据类型可由Consumer推断得出,所以可以省略,小括号也可以省略
        Consumer<String> consumer = str -> System.out.println(str);
        consumer.accept("你好,HOST");
    }

    /**
     * 有两个及以上的参数,有返回值,多条执行语句
     */
    public static void test3() {
        Comparator<Integer> comparator2 = (para1, para2) -> {
            System.out.println("有两个及以上的参数,有返回值,多条执行语句");
            return Integer.compare(para1, para2);
        };
        int compare = comparator2.compare(34, 23);
        System.out.println(compare);
    }

    /**
     * 函数式接口:只含有一个抽象方法的接口
     */
    public static void test4() {
        SupperMan<String> supperMan = str -> System.out.println("超人喜欢吃" + str);
        supperMan.eat("麻辣烫");
    }

    /**
     * 供给型接口 Supplier<T>
     */
    public static void test5() {
        Person host = new Person("Host");
        Supplier<String> supplier = () -> host.getName();
        String s = supplier.get();
        System.out.println(s);
    }
    /**
     * 函数型接口 Function<T,R>,结果为R类型的对象
     */
    public static void test6() {

        Function<String, Integer> function = (str) -> str.length();
        Integer hostLength = function.apply("Host");
        System.out.println(hostLength);
    }

    /**
     * 断言型接口,Pridicate<T>,返回boolean类型的
     */
    public static void test7() {
        Predicate<String> predicate = (str) -> str.length() > 4;
        boolean host = predicate.test("Host");
        System.out.println(host);

    }

    /**
     * BiFuction<T,U,R>继承自Function
     */
    public static void test8() {
        BiFunction<String, String, Integer> biFunction = (str1, str2) -> str1.compareTo(str2);
        Integer apply = biFunction.apply("host", "Host");
        System.out.println(apply);
    }


}
