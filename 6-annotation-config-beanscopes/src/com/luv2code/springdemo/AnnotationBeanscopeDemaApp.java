package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanscopeDemaApp {

	public static void main(String[] args) {
		
		//read spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// get bean from container
		// Coach theCoach = context.getBean("thatSillyCoach", Coach.class);
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
		
		// see if they are same
		boolean result = (theCoach == alphaCoach);
		
		System.out.println("Objects are equal: " + result);
		System.out.println(theCoach);
		System.out.println(alphaCoach);
		
		
		// close context
		context.close();

	}

}
