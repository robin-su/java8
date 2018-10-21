package com.myspring.java8.optional;

import com.myspring.java8.Employee;

import java.util.Optional;

/**
 *   Optional<T> 类(java.util.Optional) 是一个容器类，代表一个值存在或不存在，
     原来用 null 表示一个值不存在，现在 Optional 可以更好的表达这个概念。并且
     可以避免空指针异常。
     常用方法：
     Optional.of(T t) : 创建一个 Optional 实例
     Optional.empty() : 创建一个空的 Optional 实例
     Optional.ofNullable(T t):若 t 不为 null,创建 Optional 实例,否则创建空实例
     isPresent() : 判断是否包含值
     orElse(T t) : 如果调用对象包含值，返回该值，否则返回t
     orElseGet(Supplier s) :如果调用对象包含值，返回该值，否则返回 s 获取的值
     map(Function f): 如果有值对其处理，并返回处理后的Optional，否则返回 Optional.empty()
     flatMap(Function mapper):与 map 类似，要求返回值必须是Optional
 */
public class TestOptional {

    public static void main(String[] args) {
        TestOptional instance = new TestOptional();
//        instance.test1();
//        instance.test2();
//        instance.test3();

//        instance.test4();
        instance.test5();
    }



    public void test1() {
        Optional<Employee> op = Optional.of(new Employee());
        Employee employee = op.get();
        System.out.println(employee);
    }

    public void test2() {
        Optional<Object> op = Optional.empty();
        System.out.println(op.get());
    }

    public void test3() {
        Optional<Employee> op = Optional.ofNullable(null);

//        if(op.isPresent()) {
//            System.out.println(op.get());
//        }

//        Employee emp = op.orElse(new Employee("张三",18,888.88, Employee.Status.FREE));
//        System.out.println(emp);

        Employee emp1 = op.orElseGet(() -> new Employee());
        System.out.println(emp1);
    }

    public void test4() {
        Optional<Employee> op = Optional.ofNullable(new Employee("张三", 18, 888.88, Employee.Status.FREE));
//        Optional<String> str = op.map((e) -> e.getName());
//        System.out.println(str.get());

        Optional<String> str2 = op.flatMap((e) -> Optional.of(e.getName()));
        System.out.println(str2.get());
    }

    //需求：获取一个男人心中女神的名字
    public void test5() {
//        Man man = new Man();
//        String n = getGodnessName(man);
//        System.out.println(n);

        Optional<Godness> gn = Optional.ofNullable(new Godness("波多老师"));
        Optional<NewMan> op = Optional.ofNullable(new NewMan(gn));
        String str = getGodnessName2(op);
        System.out.println(str);

    }

    public static String getGodnessName2(Optional<NewMan> man) {

        return man.orElse(new NewMan())
                .getGodness()
                .orElse(new Godness("苍老师"))
                .getName();
    }

    public static String getGodnessName(Man man) {
        if(man != null) {
            Godness godness = man.getGodness();

            if(godness != null) {
                return godness.getName();
            }
        }
        return "苍老师";
    }

}
