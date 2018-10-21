package com.myspring.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestLambda3 {

	List<Employee> employees = Arrays.asList(new Employee("����", 18, 9999.99), 
			new Employee("����", 59, 6666.66),
			new Employee("����", 28, 3333.33), 
			new Employee("����", 8, 7777.77), 
			new Employee("����", 38, 5555.55));


	public void test1() {
		Collections.sort(employees,(e1,e2) -> {
			if(e1.getAge() == e2.getAge()) {
				return e1.getSalary().compareTo(e2.getSalary());
			}else {
				return -Integer.compare(e1.getAge(), e2.getAge());
			}
		});
		
		for(Employee emp : employees) {
			System.out.println(emp);
		}
	}

	public void test2() {
		String trimStr = strHandler("\t\t\t �Ҵ��й������  ",(str) -> str.trim());
		System.out.println(trimStr);
		
		String strHandler = strHandler("abcdef",(str) -> str.toUpperCase());
		System.out.println(strHandler);
		
		String strHandler2 = strHandler("�Ҵ��й������",(str) -> str.substring(2, 5));
		System.out.println(strHandler2);
		
	}
	


	public String strHandler(String str,MyFunction mf) {
		return mf.getValue(str);
	}


	public void test3() {
		op(100L,200L,(x,y) -> x+y);
		op(100L,200L,(x,y) -> x*y);
	}


	public void op(Long l1,Long l2,MyFunction2<Long,Long> mf) {
		System.out.println(mf.getValue(l1, l2));
	}

}
