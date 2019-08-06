package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component("thatSillyCoach")
@Component
@Scope("prototype")
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
	
	
	

	@Override
	public String getDailyWorkout() {

		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
	}

}
