package com.hrbust.newjava8.lambdaAndFunctionInterface;


import jdk.nashorn.internal.ir.FunctionCall;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用的使用
 *
 * Created by shkstart.
 */
public class MethodRefTest {
	public static void main(String[] args) {
		//test1();
		//test2();
		//test4();
		//test5();
		//test6();
		test7();
	}

	// 情况一：对象 :: 实例方法
	//Consumer中的void accept(T t)
	//PrintStream中的void println(T t)
	public static void test1() {
		//本质就是把println被函数式接口包装了
		Consumer<String> consumer =System.out::println;
		consumer.accept("Hrbin");
		
		
	}
	
	//Supplier中的T get()
	//Employee中的String getName()
	public static void test2() {
		Employee employee = new Employee(1, "Host");
		Supplier<String> supplier = employee::getName;
		String s = supplier.get();
		System.out.println(s);

	}

	// 情况二：类 :: 静态方法
	//Comparator中的int compare(T t1,T t2)
	//Integer中的int compare(T t1,T t2)
	public void test3() {
		Comparator<Integer> comparator = Integer::compareTo;
		int compare = comparator.compare(23, 34);
		System.out.println(compare);
	}
	
	//Function中的R apply(T t)
	//Math中的Long round(Double d)
	public static void test4() {
		Function<Double, Long> function = Math::round;
		Long apply = function.apply(23.456);
		System.out.println(apply);


	}

	// 情况三：类 :: 实例方法 
	// Comparator中的int comapre(T t1,T t2)
	// String中的int t1.compareTo(t2)
	public static void test5() {
		Comparator<String> comparator = String::compareTo;
		int compare = comparator.compare("Host", "host");
		System.out.println(compare);

	}

	//BiPredicate中的boolean test(T t1, T t2);
	//String中的boolean t1.equals(t2)
	public static void test6() {
		BiPredicate<String, String> biPredicate = String::equals;
		System.out.println(biPredicate.test("host", "host"));
		
	}
	
	// Function中的R apply(T t)
	// Employee中的String getName();
	public static void test7() {
		Function<Employee, String> function = Employee::getName;
		String host = function.apply(new Employee(2, "Host"));
		System.out.println(host);

	}

}
