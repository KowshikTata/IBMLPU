package comm.example.bean;


public class BaseBallCoach implements Coach {

	private FortuneService fortuneService;
	
	
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "practice backvolley today.!";
	}

	
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
