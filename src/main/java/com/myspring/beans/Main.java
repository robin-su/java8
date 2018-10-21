package com.myspring.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
//		HelloWorld helloWord = new HelloWorld();
//		helloWord.setName("atguigu");
		
		//1.����Spring��IOC�������� 
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//2.��IOC�����л�ȡBeanʵ��
		HelloWorld helloWord = (HelloWorld)ctx.getBean("helloWorld");
		
		helloWord.hello();
	}

}
