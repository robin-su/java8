package com.myspring.java8.func;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import com.myspring.java8.Employee;

/**
 * 方法引用：若lambda体中的内容有方法已经实现了，我们可以使用“方法引用”
 *        （可以理解为方法应用是Lambda表达式的另外一种表现形式）
 *
 * 主要有三种语法格式
 *
 * 对象::实例方法名
 *
 * 类::静态方法名
 *
 * 类::实例方法名
 *
 * 注意：
 * 		①Lambda 体中调用方法的参数列表于返回值类型，要与函数式接口中抽象方法的函数列表和返回值类型保持一致!
 * 		②若Lambda 参数列表中的第一个参数是实例方法的调用者,而第二个参数是实例方法的参数时,可以使用ClassName::method
 *
 * 二。构造器引用：
 * 		ClassName::New
 *
 * 注意：需要调用的构造器的参数列表需要与函数式接口中抽象方法的参数列表保持一致。
 *
 * 三。数组应用：
 * 		Type::new
 */
public class TestMethodRef {

	//数组应用
	public void test7() {
		Function<Integer,String[]> fun = (x) -> new String[x];
		String[] str = fun.apply(10);
		System.out.println(str);
		
		Function<Integer,String[]> fun2 = String[]::new;
		String[] strs2 = fun2.apply(20);
		System.out.println(strs2.length );
		
	}

//	构造器引用
	public void test5() {
		Supplier<Employee> sup = () -> new Employee();
		//构造器引用方式
		Supplier<Employee> sup2 = Employee::new;
		Employee emp = sup2.get();
		System.out.println(emp);
	
	}

	public void test6() {
		Function<Integer,Employee> fun = (x) -> new Employee(x);
		
		Function<Integer,Employee> fun2 = Employee::new;
		Employee emp = fun2.apply(101);
		System.out.println(emp);
	}
	
	//类::实例方法名
	public void test4() {
		BiPredicate<String, String> bp = (x,y) -> x.equals(y);
		BiPredicate<String,String> bp2 = String::equals;
		
		
	}
	
	//类::静态方法名
	public void test3() {
		Comparator<Integer> com = (x,y) -> Integer.compare(x, y);
		Comparator<Integer> com1 = Integer::compare;
	}
	
	//对象::实例方法名
	public void test1() {
		//注意这里有个要求：需要实现的抽象方法的参数列表与返回值类型，要与我当前调用这个方法的参数列表和返回值类型一致。
		//本例中Consumer的void accept(T t) 和 void println(String s) 的参数列表和返回值类型一致
		Consumer<String> con = (x) -> System.out.println(x);
		
		PrintStream ps = System.out;
		Consumer<String> con1 = ps::println;
		
		Consumer<String> con2 = System.out::println;
		con2.accept("abcdef");
	}

	public void test2() {
		Employee emp = new Employee();
		Supplier<String> sup = ()-> emp.getName();
		String str = sup.get();
		System.out.println(str);
		
		Supplier<Integer> sup2 = emp::getAge;
		Integer num = sup2.get();
		
		System.out.println(num);
	} 
	
}
