package com.gunwoo.aopstudy.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	@Before("execution(* com.gunwoo.aopstudy.service.*.get.*(..))")
	public void loggerBefore() {
		System.out.println("get 으로 시작되는 메서드 시작");
	}
	
	@After("execution(* com.gunwoo.aopstudy.service.*.get.*(..))")
	public void loggerAfter() {
		System.out.println("get 으로 시작되는 메서드 종료");
	}
	
	@Around("execution(* com.gunwoo.aopstudy.UserController.*(..))")
	public Object loggerAround(ProceedingJoinPoint pjp) throws Throwable {
		long beforeTimeMillis = System.currentTimeMillis();
		System.out.println("UserController 시작");
		Object result = pjp.proceed();
		
		long afterTimeMillis = System.currentTimeMillis() - beforeTimeMillis;
		System.out.println("UserController 종료" + afterTimeMillis+"밀리초 소요");
		return result;
	}
	
}
