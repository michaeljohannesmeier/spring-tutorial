package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		// load spring conf file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve bean from spring
		Coach theCoach = context.getBean("myCoach", Coach.class);
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		boolean result = theCoach == alphaCoach;
		
		System.out.println("\nPointing to the same object: " + result);
		System.out.println("\nMemory location theCoach " + theCoach);
		System.out.println("\nMemory location alphaCoach " + alphaCoach);
		
		context.close();

	}

}
