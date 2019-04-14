package com.johnfnash.learn.spring.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.johnfnash.learn.spring.aop.basic.service.Person;

public class BasicTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");

		Person person = (Person) context.getBean("chinese");
		person.sayHello("xxx");
		
		System.out.println(person.getClass());
		
		context.close();
	}
	
}
