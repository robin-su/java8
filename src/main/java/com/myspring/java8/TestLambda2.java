package com.myspring.java8;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 *
 * 一：Lambda 表达式的基础语法：Java8中引入的一个新的操作符“->” 该操作符成为箭头操作符或Lambda操作符
 * 						  箭头操作符将Lambda表达式拆分成两部分
 *
 *左侧：Lambda 表达式的参数列表
 *右侧：Lambda 表达式中所需要执行的功能，即Lambda体
 *
 *语法格式一：无参数，无返回值
 *		() -> System.out.println("Hello Lambda!")
 *
 *语法格式二：有一个参数，并且无返回值
 *		(x) -> System.out.println(x);
 *
 *语法格式三：若只有一个参数，小括号可以省略不写
 *		x ->  System.out.println(x);
 *
 *语法格式四：有两个以上的参数，有返回值，并且Lambda体中有多条语句
 *		Comparator<Integer> com = (x,y) -> {
 System.out.println("函数是接口");
 return Integer.compare(x, y);
 };

 语法格式五：若Lambda体中只有一条语句，return和大括号都可以省略不写
 Comparator<Integer> com = (x,y) -> Integer.compare(x, y);


 语法格式六：Lambda 表达式的参数列表的数据类型可以省略不写，因为JVM编译器可以通过上下文推断出，数据类型，即"类型推断"
 Comparator<Integer> com = (x,y) -> Integer.compare(x, y);

 二： lambda 表达式需要"函数式接口"的支持
 函数式接口：接口中只有一个抽象方法的接口，称为函数式接口。可以使用注解@FunctionalInterface 修饰一下
 可以检查是否是函数式接口
 */
public class TestLambda2 {

	public static void main(String[] args) {

	}

	public static void test1() {
		
		int num = 0;//jdk 1.7ǰ��������final
		
		Runnable r = new Runnable() {
			@Override
			public void run() {
				System.out.println("Hello World!" + num);
			}
		};
		
		r.run();
		
		System.out.println("--------------------------------");
		
		Runnable r1 = () -> System.out.println("Hello Lambda!");
		
		r1.run();
	}

	public static void test2() {
		//��Consumer�ӿ��е�accept������ʵ��
		Consumer<String> con = (x) -> System.out.println(x);
		con.accept("�ҵ��й�����䣡");
	}

	public static void test3() {
		Comparator<Integer> com = (x,y) -> {
			System.out.println("�����ǽӿ�");
			return Integer.compare(x, y);
		};
	}

	public static void test4() {
		Comparator<Integer> com = (x,y) -> Integer.compare(x, y);
	}

	public static void test5() {
		String[] strs = {"aaa","bbb","ccc"};
	}

	public static void test6() {
		Integer num = operation(100,(x) -> x * x);
		System.out.println(num);
	}
	
	public static Integer operation(Integer num,MyFun mf) {
		return mf.getValue(num);
	}
	
	
}
