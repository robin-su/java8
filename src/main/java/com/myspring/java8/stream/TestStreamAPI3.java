package com.myspring.java8.stream;

import com.myspring.java8.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class TestStreamAPI3 {

    List<Employee> employees = Arrays.asList(
            new Employee("张三",18,9999.99, Employee.Status.FREE),
            new Employee("李四",58,5555.55, Employee.Status.BUSY),
            new Employee("王五",26,3333.33, Employee.Status.VOCATION),
            new Employee("赵六",36,6666.66, Employee.Status.FREE),
            new Employee("田七",12,8888.88, Employee.Status.BUSY),
            new Employee("田七",12,8888.88, Employee.Status.BUSY)
    );


    public static void main(String[] args) {
        TestStreamAPI3 instances = new TestStreamAPI3();
//        instances.test1();
//        instances.test2();
//        instances.test3();
//        instances.test4();
//        instances.test5();
//        instances.test6();
//        instances.test7();
//        instances.test8();
//        instances.test9();
        instances.test10();
    }

    //
    public void test10() {
        String str = employees
                .stream()
                .map(Employee::getName)
                .collect(Collectors.joining(","));
        System.out.println(str);

    }

    //
    public void test9() {
        DoubleSummaryStatistics dss = employees
                .stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(dss.getMax());
        System.out.println(dss.getMin());
        System.out.println(dss.getAverage());
        System.out.println(dss.getSum());

    }

    //分片
    public void test8() {
        Map<Boolean, List<Employee>> collect = employees.stream()
                .collect(Collectors.partitioningBy((e) -> e.getSalary() > 8000.0));
        System.out.println(collect);

    }

    //多级分组
    public void test7() {
        Map<Employee.Status, Map<String, List<Employee>>> map = employees.stream().collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy((e) -> {
            if (((Employee) e).getAge() <= 35) {
                return "青年";
            } else if (((Employee) e).getAge() <= 50) {
                return "中年";
            } else {
                return "老年";
            }
        })));

        System.out.println(map);
    }

    //分组
    public void test6() {
        Map<Employee.Status, List<Employee>> map = employees.stream().collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println(map);
    }

    public void test5() {
        //总数
        Long count = employees
                .stream()
                .collect(Collectors.counting());
        System.out.println(count);

        System.out.println("-------------------------------------");

        //平均值
        Double avg = employees.stream().collect(Collectors.averagingDouble(Employee::getSalary));

        //总和
        Double sum = employees.stream().collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println(sum);

        //工资最多的员工信息
        Optional<Employee> max = employees
                .stream()
                .collect(Collectors.maxBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())));
        System.out.println(max.get());

        //获取员工的最小工资
        Optional<Double> min = employees.stream().map(Employee::getSalary).collect(Collectors.minBy(Double::compare));
        System.out.println(min.get());
    }

    /**
     * 收集
     *
     * collect -- 将流转换为其他形式。接收一个Collector接口的实现，用于给Stream中元素做汇总的方法
     */
    public void test4() {
        List<String> list = employees.stream().map(Employee::getName).collect(Collectors.toList());
        list.forEach(System.out::println);

        System.out.println("------------------------------------");
        Set<String> set = employees.stream().map(Employee::getName).collect(Collectors.toSet());
        set.forEach(System.out::println);

        System.out.println("------------------------------------");
        HashSet<String> hs = employees
                .stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(HashSet::new));
        hs.forEach(System.out::println);

    }

    /**
     * 归约
     * reduce(T identity,BinaryOperator) / reduce(BinaryOperator) -- 可以将流中元素反复结合起来，得到一个值
     * identity 表示起始值
     * BinaryOperator 表示二元运算
     */
    public void test3() {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Integer sum = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println(sum);

        System.out.println("-----------------------------------");

        Optional<Double> op = employees.stream().map(Employee::getSalary).reduce(Double::sum);
        System.out.println(op.get());
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
