package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		// read spring config class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from sping container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		// call the business method
		theAccountDAO.addAccount();
		
		theMembershipDAO.addAccount();
		
		theAccountDAO.addAccount();
		
		// close the context
		context.close();

	}

}
