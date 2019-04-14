package com.johnfnash.learn.spring.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.johnfnash.learn.spring.aop.basic.HelloWorld;

public class BasicTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
		
		// 注意：这里需要使用接口来接收（基于接口的默认使用的 JDK 动态代理，通过实现接口来....）
		HelloWorld hw1 = (HelloWorld) context.getBean("helloWorldImpl1");
		HelloWorld hw2 = (HelloWorld) context.getBean("helloWorldImpl2");
		hw1.printHelloWorld();
		System.out.println();
		hw1.doPrint();
		
		System.out.println();
		hw2.printHelloWorld();
		System.out.println();
		hw2.doPrint();
		
		context.close();
	}
	
}
