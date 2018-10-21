package com.myspring.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


import com.myspring.java8.Employee;

/**
 * 一.Stream 的三个操作步骤：
 * 	1.创建Stream
 *
 *  2.中间操作
 *
 *  3.终止操作（终端操作）
 *
 */
public class TestStreamAPI1 {

	public static void main(String[] args) {
		test1();
	}

	//创建Stream
	public static void test1() {
		//1.可以通过CollecTesttion 系列集合提供的Stream()或parallelStream()
		List<String> list = new ArrayList<>();
		Stream<String> stream1 = list.stream();

		//2.通过Arrays中的静态方法stream()获取数组流
		Employee[] emps = new Employee[10];
		Stream<Employee> stream2 = Arrays.stream(emps);

		//3.通过Stream类中的静态方法of()创建流
		Stream<String> stream3 = Stream.of("aa","bb","cc");

		//4.创建无限流
		Stream<Integer> stream4 = Stream.iterate(0, (x)-> x+2);
		stream4.limit(10).forEach(System.out::println);

		//生产
		Stream.generate(() -> Math.random()).limit(5).forEach(System.out::println);
	}
	
}
