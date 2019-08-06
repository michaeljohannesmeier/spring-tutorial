package com.luv2code.springdemo;

public class TrackCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;	
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}
	
	@Override
	public String getDailyFortune() {
		return "Just do it: " + fortuneService.getFortune();
	}
	
	// add an init method for lifecycle hook
	public void doMyStartupStuff() {
		System.out.println("in init method doMyStart");
	}
	
	// add an destroy method for lifecycle hook
	public void doMyCleanupStuff() {
		System.out.println("in destroy method doMyClean");
	}
}
