package com.myspring.java8;

import java.util.Objects;

public class Employee {
	
	private int id;
	private String name;
	private Integer age;
	private Double salary;
	private Status status;
	

	public Employee() {
		super();
	}

	public Employee(int id) {
		super();
		this.id = id;
	}
	
	public Employee(int id,int age) {
		this.id = id;
		this.age = age;
	}

	public Employee(String name, int age, double salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public Employee(String name, Integer age, Double salary, Status status) {
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Employee)) return false;
		Employee employee = (Employee) o;
		return getId() == employee.getId() &&
				getAge() == employee.getAge() &&
				Objects.equals(getName(), employee.getName()) &&
				Objects.equals(getSalary(), employee.getSalary());
	}

	@Override
	public int hashCode() {

		return Objects.hash(getId(), getName(), getAge(), getSalary());
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public enum Status {
		FREE,
		BUSY,
		VOCATION;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"id=" + id +
				", name='" + name + '\'' +
				", age=" + age +
				", salary=" + salary +
				", status=" + status +
				'}';
	}
}
