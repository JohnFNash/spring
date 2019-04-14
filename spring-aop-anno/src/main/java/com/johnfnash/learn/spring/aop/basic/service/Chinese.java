package com.johnfnash.learn.spring.aop.basic.service;

import org.springframework.stereotype.Component;

@Component
public class Chinese implements Person {

	@Override
	public String sayHello(String name) {
		System.out.println("-- sayHello() --");
		return name + " hello, AOP";
	}

}
