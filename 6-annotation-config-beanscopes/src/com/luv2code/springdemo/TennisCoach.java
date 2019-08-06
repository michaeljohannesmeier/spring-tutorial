package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component("thatSillyCoach")
@Component
@Scope("singleton")
public class TennisCoach implements Coach {
	
	@Autowired
	@Qualifier("happyFortuneService")
	private FortuneService fortuneService;
	
	// Construction injection:
	//@Autowired
	//public TennisCoach(FortuneService theFortuneService) {
	//	fortuneService = theFortuneService;
	//}
	
	public TennisCoach() {
		System.out.println("inside default constructor");
	}
	
	// Setter injection
	//@Autowired
	//public void setFortuneService(FortuneService theFortuneService) {
	//	fortuneService = theFortuneService;
	//}
	
	//@PostConstruct
	public void myStartupStuff() {
		System.out.println("inside doStartupStart");
	}
	
	//@PreDestroy
	public void myCleanupStuff() {
		System.out.println("inside myCleanupStuff");
	}
	

	@Override
	public String getDailyWorkout() {

		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
	}

}
