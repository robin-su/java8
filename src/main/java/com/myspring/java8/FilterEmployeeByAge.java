package com.myspring.java8;

public class FilterEmployeeByAge implements MyPredicate<Employee> {

	@Override
	public boolean test(Employee t) {
		return t.getAge() >= 35;
	}

}
