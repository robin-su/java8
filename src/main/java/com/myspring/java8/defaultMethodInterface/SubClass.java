package com.myspring.java8.defaultMethodInterface;

public class SubClass extends MyClass implements MyFun,MyInterface{

    public static void main(String[] args) {
        SubClass sc = new SubClass();
        System.out.println(sc.getName());
    }

}
