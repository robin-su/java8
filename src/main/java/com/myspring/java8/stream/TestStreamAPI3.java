package com.myspring.java8.stream;

import com.myspring.java8.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TestStreamAPI3 {

    List<Employee> employees = Arrays.asList(
            new Employee("张三",18,9999.99, Employee.Status.FREE),
            new Employee("李四",58,5555.55, Employee.Status.BUSY),
            new Employee("王五",26,3333.33, Employee.Status.VOCATION),
            new Employee("赵六",36,6666.66, Employee.Status.FREE),
            new Employee("田七",12,8888.88, Employee.Status.BUSY)
    );


    public static void main(String[] args) {
        TestStreamAPI3 instances = new TestStreamAPI3();
        instances.test1();
        instances.test2();
    }

    /**
     * 查找与匹配
     * allMatch --检查是否匹配所有元素
     * anyMatch -- 检查至少匹配一个元素
     * noneMatch -- 检查是否没有匹配所有元素
     * findFirst -- 返回第一个元素
     * findAny -- 返回当前流中的任意元素
     * count -- 返回流中元素的总个数
     * max -- 返回流中最大值
     * min -- 返回流中最小值
     */
    public void test1() {
        boolean b1 = employees.stream().allMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b1);

        boolean b2 = employees.stream().anyMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b2);

        boolean b3 = employees.stream().noneMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.print(b3);

        Optional<Employee> op = employees
                .stream()
                .sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
                .findFirst();

        System.out.println(op.get());

        Optional<Employee> any = employees
                .stream()
                .filter((e) -> e.getStatus().equals(Employee.Status.FREE))
                .findAny();

        System.out.println(any.get());
    }

    public void test2() {
        long count = employees.stream().count();
        System.out.println(count);

        Optional<Employee> op1 = employees.stream().max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(op1);

        Optional<Double> min = employees.stream().map(Employee::getSalary).min(Double::compareTo);
        System.out.println(min.get());
    }
}
