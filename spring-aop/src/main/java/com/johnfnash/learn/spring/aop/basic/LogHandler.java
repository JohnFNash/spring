package com.johnfnash.learn.spring.aop.basic;

public class LogHandler {

	public void logBefore() {
		System.out.println("Log before method");
	}

	public void logAfter() {
		System.out.println("Log after method");
	}

}
