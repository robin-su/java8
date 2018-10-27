package com.myspring.java8.annotation;

import com.sun.istack.internal.NotNull;

import java.lang.reflect.Method;

/**
 * 重复注解与类型注解
 *
 */
public class TestAnnotation {

    private @NotNull Object obj = null;

    public static void main(String[] args) throws Exception{
        Class<TestAnnotation> clazz = TestAnnotation.class;
        Method m1 = clazz.getMethod("show");
        MyAnnotataion[] mas = m1.getAnnotationsByType(MyAnnotataion.class);

        for(MyAnnotataion myAnnotataion:mas) {
            System.out.println(myAnnotataion.value());
        }
    }

    @MyAnnotataion("Hello")
    @MyAnnotataion("Word")
    public void show(@MyAnnotataion("abc") String str) {

    }

}
