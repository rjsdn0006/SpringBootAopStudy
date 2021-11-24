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
		System.out.println("get ���� ���۵Ǵ� �޼��� ����");
	}
	
	@After("execution(* com.gunwoo.aopstudy.service.*.get.*(..))")
	public void loggerAfter() {
		System.out.println("get ���� ���۵Ǵ� �޼��� ����");
	}
	
	@Around("execution(* com.gunwoo.aopstudy.UserController.*(..))")
	public Object loggerAround(ProceedingJoinPoint pjp) throws Throwable {
		long beforeTimeMillis = System.currentTimeMillis();
		System.out.println("UserController ����");
		Object result = pjp.proceed();
		
		long afterTimeMillis = System.currentTimeMillis() - beforeTimeMillis;
		System.out.println("UserController ����" + afterTimeMillis+"�и��� �ҿ�");
		return result;
	}
	
}
