package com.myspring.java8.stream;

import com.myspring.java8.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class TestStreamAPI2 {

    public static void main(String[] args) {
        TestStreamAPI2 instance = new TestStreamAPI2();
//        instance.test1();
//        instance.test2();
//        instance.test3();
//        instance.test6();

        instance.test7();
    }


    List<Employee> employees = Arrays.asList(
            new Employee("张三",18,9999.99),
            new Employee("李四",58,5555.55),
            new Employee("王五",26,3333.33),
            new Employee("赵六",36,6666.66),
            new Employee("田七",12,8888.88)
    );

    //内不迭代：迭代操作由Stream API完成
    public void test1() {
        //中间操作
        Stream<Employee> stream = employees.stream().filter((e) -> {
            System.out.println("Stream API 的中间操作"); //在没有终止操走forEach的时候，打印不会执行。
            return e.getAge() > 35;
        });

        /**
         *  终止操作：
         *  多个中间操作可以连接起来形成一个流水线，除非流水
         *  线上触发终止操作，否则中间操作不会执行任何的处理！
         *  而在终止操作时一次性全部处理，称为“惰性求值” 。
         */
        stream.forEach(System.out::println);
    }

    //外部迭代：
    public void test2() {
        Iterator<Employee> it = employees.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }


    /**
     * 排序：
     * sorted() -- 自然排序
     * sorted(Comparator com) -- 自然排序
     */
    public void test7() {
        List<String> list = Arrays.asList("aaa","bbb","ccc","ddd","eee");
        list.stream().sorted().forEach(System.out::println);
        System.out.println("------------------------------------------");

        employees.stream().sorted((e1,e2) -> {
            if(e1.getAge().equals(e2.getAge())) {
                return e1.getName().compareTo(e2.getName());
            }else{
                return e1.getAge().compareTo(e2.getAge());
            }
        }).forEach(System.out::println);
    }

    /**
     * 映射：
     *   map -- 接收Lambda，将元素转换成其他形式或提取信息。接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素
     *   flatMap -- 接收一个函数作为参数，将流中的每个值都换成一个流。
     */
    public void test6() {
        List<String> list = Arrays.asList("aaa","bbb","ccc","ddd","eee");
        list.stream().map(str -> str.toUpperCase()).forEach(System.out::println);

        System.out.println("------------------------------------------");
        employees.stream().map(Employee::getName).forEach(System.out::println);

        Stream<Stream<Character>> streamStream = list.stream().map(TestStreamAPI2::filterCharacter);
        streamStream.forEach((sm) -> {
            sm.forEach(System.out::print);
        });

        System.out.println("------------------------------------------");

        Stream<Character> characterStream = list.stream().flatMap(TestStreamAPI2::filterCharacter);
        characterStream.forEach(System.out::println);

    }

    public static Stream<Character> filterCharacter(String str) {
        List<Character> list = new ArrayList<>();
        for(Character ch : str.toCharArray()) {
            list.add(ch);
        }
        return list.stream();
    }


    /**
     * 筛选与切片
     * filter -- 接收Lambda,从流中排除某些元素。
     * limit -- 截断流，使其元素不超过给定数量
     * skip(n) -- 跳过元素，返回一个扔掉了前n个元素的流，若流中元素不足n个，则返回一个空流，与limit(n)互补
     * distinct -- 筛选，通过流所生成元素的hashCode()和equals() 去除重复元素。（被去重元素要重写HashCode和equals方法）
     *
     * skip 跳过前2个
     *
     */
    public void test5() {
        employees.stream().filter((e) -> e.getSalary() > 5000).skip(2).forEach(System.out::println);
    }

    //
    public void test3() {
        employees.stream()
                .filter((e) -> e.getSalary() > 5000)
                .limit(2)
                .forEach(System.out::println);
    }

}
