package com.johnfnash.learn.spring.aop.basic.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {

	// 定义切面
	@Pointcut("execution(* com.johnfnash.learn.spring.aop.basic.service..*(..))")
	public void pointcut() {
    }
 
	@Before("pointcut()" )
	public void before() {
		System.out.println("before");
	}
	
	@Around("pointcut()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("StartTime = " + System.currentTimeMillis());
		Object retVal = pjp.proceed();
		System.out.println("EndTime = " + System.currentTimeMillis());
		
		return retVal;
	}
	
}
