
public class TimeMagement implements Entity{
	
	private static final int COOLDOWN = 2;
	public SorcererGame game;
	public int count_time = 0,time = 0;
	public int count_delay1 = 0;
	public int count_delay2 = 0;
	public boolean isSkill1Used = false;
	public float delaySkill1 = 0;
	public boolean isSkill2Used;
	public float delaySkill2 = 0;
	
	public void timeCounter(int delta) {
		handleSkill1Delay(delta);
		handleTime(delta);
		handleSkill2Delay(delta);
	}

	private void handleTime(int delta) {
		count_time += delta;
		if(count_time >= 1000){
	    	time += 1;
	    	count_time = 0;
	    }
	}

	private void handleSkill2Delay(int delta) {
		if(isSkill2Used){
			count_delay2 += delta;
			if(count_delay2 >= 100){
				delaySkill2 += 0.1;	
				count_delay2 = 0;
			}
			if(delaySkill2 >= COOLDOWN){
				delaySkill2 = 0;
				isSkill2Used = false;
			}
		}
	}

	

	private void handleSkill1Delay(int delta) {
		if(isSkill1Used){
			count_delay1 += delta;
			if(count_delay1 >= 100){
				delaySkill1 += 0.1;	
				count_delay1 = 0;
			}
			if(delaySkill1 >= COOLDOWN){
				delaySkill1 = 0;
				isSkill1Used = false;
			}
		}
	}

	public void skill1DelayCheck(Skill skill1){
		if(delaySkill1 == 0){
			skill1.isrelease = true;
			isSkill1Used = true;
		}
		else{
			skill1.isrelease = false;
		}
	}
	
	public void skill2DelayCheck(Skill skill2){
		if(delaySkill2 == 0){
			skill2.isrelease = true;
			isSkill2Used = true;
		}
		else{
			skill2.isrelease = false;
		}
	}
	
	@Override
	public void update(int delta) {
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}

}
