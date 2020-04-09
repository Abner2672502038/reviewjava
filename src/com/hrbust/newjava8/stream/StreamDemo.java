package com.hrbust.newjava8.stream;

/**
 * @program: reviewJava
 * @description: 强大的StreamApi
 * @author: Abner
 * @create: 2020-03-15 13:15
 */

import com.hrbust.newjava8.lambdaAndFunctionInterface.Employee;
import com.hrbust.newjava8.lambdaAndFunctionInterface.EmployeeData;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Collection是静态的内存数据结构
 * Stream是用于计算的
 */
public class StreamDemo {

    public static void main(String[] args) {
        //test1();
        //test2();
       // test3();
        //test4();
       // test5();
       // test6();
       // test7();
        //test8();
      //  test9();
        test10();

    }

    /**
     * 创建Stream:方式1:通过集合,流只能使用依次
     */
    public static void test1() {

        //顺序流
        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().forEach(System.out::println);
        System.out.println();
        //并行流
        employees.parallelStream().forEach(System.out::println);

    }

    /**
     * 方式2:通过数组,通过Arrays的静态方法stream(T[] arr)过去流
     */
    public static void test2() {
        Arrays.stream(new int[]{1, 2, 3, 4, 5}).forEach(System.out::println);

    }

    /**
     * 方式3:通过Stream的of(T...val)来创建
     */
    public static void test3() {
        Stream.of("AT&T", "google", "IBM", "摩托罗拉", "英特尔").forEach(System.out::println);

    }

    /**
     * 方式4:创建无限流Stream.iterate(final T seed, final UnaryOperator<T> f),Stream.generate(Supplier<T> s)
     */
    public static void test4() {
        //生成,表示的到所有偶数,不加limit()为死循环
        Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);
        //迭代,产生10个随机数
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }

    /**
     * Strea的中间操作,为惰性求值,除非流水线触发终止操作,否则中间操作不会执行,直到遇到终止操作,一次执行完
     */
    /**
     * 1.筛选与切片
     */
    public static void test5() {
        List<Employee> employees = EmployeeData.getEmployees();
        //Stream<T> filter(Predicate<? super T> predicate),过滤
        employees.stream().filter(e -> e.getAge() > 30).forEach(System.out::println);
        System.out.println();
        //distinct,去除重复元素
        employees.add(new Employee(1002, "马云", 12, 9876.12));
        employees.stream().distinct().forEach(System.out::println);
        System.out.println();
        //limit(),限制元素,不再测试;skip(long n),略去前n个
        employees.stream().skip(3).forEach(System.out::println);
    }

    /**
     * 2.映射
     */
    public static void test6() {
        //map(Function<? super T, ? extends R> mapper)
        List<Employee> employees = EmployeeData.getEmployees();
        //map中的函数作用于每个元素
        employees.stream().map(employee -> employee.getAge() + 10).forEach(System.out::println);
        System.out.println();
        // <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper),把流中每个值换成另外的值,所有流组成一个流
        List<String> list = Arrays.asList("host", "hrbin");
        list.stream().flatMap(StreamDemo::fromStringToChar).forEach(System.out::println);

    }

    public static Stream<Character> fromStringToChar(String str) {
        ArrayList<Character> characters = new ArrayList<>();
        for (char c : str.toCharArray()) {
            characters.add(c);
        }
        return characters.stream();
    }

    /**
     * 3.排序
     */
    public static void test7() {
        List<Integer> list = Arrays.asList(23, 12, 67, 3, 56, 99, 66);
        //自然排序
        list.stream().sorted().forEach(System.out::println);
        System.out.println();
        //定制排序
        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().sorted((employee1, employee2) -> {
            int num = Double.compare(employee1.getSalary(), employee2.getSalary());
            if (num != 0) {
                return num;
            } else {
                return Integer.compare(employee1.getAge(), employee2.getAge());
            }
        }).forEach(System.out::println);
    }
    /**
     * Stream的终止操作;1.匹配与查找;2.归约;3.收集
     */
    /**
     * 1.匹配与查找
     */
    public static void test8() {
        //allMatch检查是否匹配每个元素
        List<Employee> employees = EmployeeData.getEmployees();
        boolean b = employees.stream().allMatch(e -> e.getSalary() > 5000);
        System.out.println(b);
        //anyMatch,检查是否有一个匹配
        boolean b1 = employees.stream().anyMatch(e -> e.getSalary() > 5000);
        System.out.println(b1);
        //noneMatch,检查是否没有一个匹配
        boolean b2 = employees.stream().noneMatch(e -> e.getName().length() >= 4);
        System.out.println(b2);

        //findFirst:寻找流中第一个元素,findAny:随机的一个
        Optional<Employee> first = employees.stream().findFirst();
        System.out.println(first.get());
    }

    /**
     * 2.规约,计算,数据分析
     */
    public static void test9() {
        List<Integer> list = Arrays.asList(23, 45, 67, 12, 66);
        //    T reduce(T identity:表示初值, BinaryOperator<T> accumulator)
        Integer reduce = list.stream().reduce(0, (num1, num2) -> num1 + num2);
        //求总和
        System.out.println(reduce);
        System.out.println();
        List<Employee> employees = EmployeeData.getEmployees();
        Optional<Double> reduce1 = employees.stream().map(employee -> employee.getSalary()).reduce((em1, em2) -> em1 + em2);
        System.out.println(reduce1.get());
    }

    /**
     * 3.收集
     */
    public static void test10() {
        //collect(Collector c):收集
        List<Employee> employees = EmployeeData.getEmployees();
        Set<Employee> collect = employees.stream().collect(Collectors.toSet());
        Iterator<Employee> iterator = collect.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());

        }
    }




}
