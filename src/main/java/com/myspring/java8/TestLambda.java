package com.myspring.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;


public class TestLambda {

	//原来的匿名内部类
	public static void test1() {
		Comparator<Integer> com = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o1, o2);
			}
			
		};
		
		TreeSet<Integer> ts = new TreeSet<>(com);
	}

	//Lambda 表达式
	public void test2() {
		Comparator<Integer> com = (x,y) -> Integer.compare(x,y);
		TreeSet<Integer> ts = new TreeSet<>(com);
 	}

	//需求：获取当前公司中员工年龄大于35的员工信息
	List<Employee> employees = Arrays.asList(
			new Employee("����",18,9999.99),
			new Employee("����",50,5555.99),
			new Employee("����",35,6666.99),
			new Employee("����",40,3333.99),
			new Employee("����",45,7777.99));
	
	public List<Employee> filterEmployees(List<Employee> list) {
		List<Employee> emps = new ArrayList<>();
	
		for(Employee emp: emps) {
			if(emp.getAge() >= 35) {
				emps.add(emp);
			}
		}
		
		return emps;
	}

	public void test3() {
		List<Employee> list = filterEmployees(employees);
		for(Employee employee: list) {
			System.out.println(employee);
		}
	}

	//需求：获取当前公司中员工工资大于5000的员工信息
	public List<Employee> filterEmployees2(List<Employee> list){
		List<Employee> emps = new ArrayList<>();
		
		for(Employee emp: emps) {
			if(emp.getSalary() >= 500) {
				emps.add(emp);
			}
		}
		return emps;
	}

	public void test4() {
		List<Employee> list = filterEmployee(employees,new FilterEmployeeByAge());
		for(Employee employee : list) {
			System.out.println(employee);
		}
		
		System.out.println("--------------------------------");
		List<Employee> list2 = filterEmployee(list,new FilterEmployeeBySalary());
		
		for(Employee employee : list2) {
			System.out.println(employee);
		}
		
	}

	/**
	 * 优化方式1:策略设计模式
	 * @param list
	 * @param mp
	 * @return
	 */
	public List<Employee> filterEmployee(List<Employee> list,MyPredicate<Employee> mp) {
		List<Employee> emps = new ArrayList<>();
		for(Employee employee : list) {
			if(mp.test(employee)) {
				emps.add(employee);
			}
		}
		return emps;
	}
	
	//优化方式2：匿名内部类
	public void test5() {
		List<Employee> list = filterEmployee(employees,new MyPredicate<Employee>() {
			@Override
			public boolean test(Employee t) {
				return t.getSalary() <= 5000;
			}
		});
		
		for(Employee employee : list) {
			System.out.println(employee);
		}
	}
	
	//优化方式3：Lambda表达式
	public void test6() {
		List<Employee> list = filterEmployee(employees,(e) -> e.getSalary() <= 5000);
		list.forEach(System.out::println);
	}
	
	//优化方式4：
	public void test7() {
		employees.stream()
				.filter((e) -> e.getSalary() >= 5000)
				.forEach(System.out::println);
		
		System.out.println("-----------------------------------");
		
		employees.stream()
			.map(Employee::getName)
			.forEach(System.out::println);
		
	}

	public void test8() {
		
	}
	
}
