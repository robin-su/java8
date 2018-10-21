package com.myspring.java8.parallelStream;

import com.myspring.java8.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TestStreamAPI {

    public static void main(String[] args) {
        TestStreamAPI testStreamAPI = new TestStreamAPI();
        testStreamAPI.test1();
        testStreamAPI.test2();
    }

    /**
     * 求列表数平方
     */
    public void test1() {
        Integer[] nums = new Integer[]{1,2,3,4,5};
        Arrays.stream(nums)
                .map((x) -> x * x)
                .forEach(System.out::println);
    }

    List<Employee> employees = Arrays.asList(
            new Employee("张三",18,9999.99, Employee.Status.FREE),
            new Employee("李四",58,5555.55, Employee.Status.BUSY),
            new Employee("王五",26,3333.33, Employee.Status.VOCATION),
            new Employee("赵六",36,6666.66, Employee.Status.FREE),
            new Employee("田七",12,8888.88, Employee.Status.BUSY),
            new Employee("田七",12,8888.88, Employee.Status.BUSY)
    );


    /**
     * 怎么样用map和reduce方法数一数流中有多少个Employee呢？
     */
    public void test2() {
        Optional<Integer> count = employees.stream().map((e) -> 1).reduce(Integer::sum);
        System.out.println(count.get());
    }
}
