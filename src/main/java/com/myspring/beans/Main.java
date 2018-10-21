package com.myspring.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
//		HelloWorld helloWord = new HelloWorld();
//		helloWord.setName("atguigu");
		
		//1.创建Spring的IOC容器对象 
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//2.从IOC容器中获取Bean实例
		HelloWorld helloWord = (HelloWorld)ctx.getBean("helloWorld");
		
		helloWord.hello();
	}

}
