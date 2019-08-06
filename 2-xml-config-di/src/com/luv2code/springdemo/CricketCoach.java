package com.luv2code.springdemo;

public class CricketCoach implements Coach {
	
	private FortuneService fortuneService;
	private String emailAddress;
	private String team;
	
	public CricketCoach() {
		System.out.print("CricketCoach: inside no-arg contrurctor");
	}
	
	public void setFortuneService(FortuneService fortuneService) {
		System.out.print("CricketCoach: inside setter-method cricket coach");
		this.fortuneService = fortuneService;
	}
	
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		System.out.print("CricketCoach: inside setEmailAddress");
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.print("CricketCoach: inside setTeam");
		this.team = team;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice fast bowloing for 15 minutes";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
