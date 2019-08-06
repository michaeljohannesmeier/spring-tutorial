package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	@Pointcut("execution(* add*())")
	public void forDAOPackage() {}
	
	//@Before("execution(public void com.luv2code.aopdemo.dao.MembershipDAO.addAccount())")
	
	//@Before("execution(public void add*())")
	
	//@Before("execution(int add*())")
	
	@Before("forDAOPackage()")
	public void beforeAddAccountAdvice() {
		System.out.println("====> Executing @Before advice on AddAccount");
	}
}
