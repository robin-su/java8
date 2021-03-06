package com.myspring.java8.func;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;



/**
 * Java8 内置的四大核心函数是接口
 *
 * Consumer<T> : 消费型接口
 * 		void accept(T t);
 *
 * Supplier<T>: 供给型接口
 * 		T get();
 *
 * Function<T,R> : 函数型接口
 * 		R apply(T t);
 *
 * Predicate<T> : 断言型接口
 * 		boolean test(T t);
 */
public class TestLambda {

	public void test4(){
		List<String> list = Arrays.asList("Hello","atguigu","Lambda","www","ok");
		List<String> strList = filterStr(list,(s) -> s.length() > 3);
		for(String str : strList) {
			System.out.println(str);
		}
	}

	public List<String> filterStr(List<String> list,Predicate<String> pre) {
		List<String> strList = new ArrayList<>();
		for(String str : list) {
			if(pre.test(str)) {
				strList.add(str);
			}
		}
		return strList;
	}

	public void test3() {
		String newStr = strHandler("\t\t\t �ҵ��й������  ",(str) -> str.trim());
		System.out.println(newStr);
		
		String substr = strHandler("�ҵ��й������",(str) -> str.substring(2, 5));
		System.out.println(substr);
	}
	

	public String strHandler(String str,Function<String,String> fun) {
		return fun.apply(str);
	}
	

	public void test2() {
		List<Integer> numList = getNumList(10, () -> (int)(Math.random() * 100));
		
		for(Integer num : numList) {
			System.out.println(num);
		}
	}
	

	public List<Integer> getNumList(int num,Supplier<Integer> sup) {
		List<Integer> list = new ArrayList<>();
		
		for(int i=0;i<num; i++) {
			Integer n = sup.get();
			list.add(n);
		}
		
		return list;
	}


	public void test1() {
		happy(10000,(m) -> System.out.println("���Ǹո�ϲ���󱦽���ÿ�����ѣ�" + m + "Ԫ"));
	}
	
	public void happy(double money,Consumer<Double> con) {
		con.accept(money);
	}
	
}
