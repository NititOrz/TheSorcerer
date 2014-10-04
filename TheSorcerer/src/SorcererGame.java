import java.util.ArrayList;
import java.util.LinkedList;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;



public class SorcererGame extends BasicGame{
	
	
	public static final int GAME_WIDTH = 640;
	public static final int GAME_HEIGHT = 480;
	public int count = 0,time = 0;
	public WhiteSorcerer white;
	public BlackSorcerer black;
	public Sorcerer sorcerer;
	public Map map;
	private int numSkill1 = 0;
	private int numSkill2 = 0;
	private boolean isStarted;
	private boolean isGameOver;
	private boolean isRestart;
	
	
	public ArrayList<Skill> skill1 = new ArrayList<Skill>();
	public ArrayList<Skill> skill2 = new ArrayList<Skill>();
	private LinkedList<Entity> entities ;
	
	
	public SorcererGame(String SorcererGame){
		super(SorcererGame);
		entities = new LinkedList<Entity>();
	}
	

	public void render(GameContainer container, Graphics g) throws SlickException {
		for (Entity entity : entities) {
		      entity.draw();
		    }
		for (Skill skill : skill1) {
		      skill.draw();
		    }
		for (Skill skill : skill2) {
		      skill.draw();
		    }
		
	}

	
	@Override
	public void init(GameContainer container) throws SlickException {
		white = new WhiteSorcerer(GAME_WIDTH/6-45,GAME_HEIGHT/2-32);
		black = new BlackSorcerer(GAME_WIDTH/6*5,GAME_HEIGHT/2-32);
		map = new Map(0,0);
		entities.add(map);
		entities.add(white);
		entities.add(black);
		
		
	}

	
	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		for (Entity entity : entities) {
		      entity.update(delta);
		    }
	    for (Skill skill : skill1) {
		      skill.update(delta);
		    }
	    for (Skill skill : skill2) {
		      skill.update(delta);
		    }
	    
	    Input input = container.getInput();
	    controllerSorcerer(input);
	    blackSorcererController(input);
	    whiteSorcererController(input);
	    checkSkillCollision();
	    timeCounter(delta);
		
	}


	private void timeCounter(int delta) {
		count += delta;
		if(count >= 1000){
	    	time += 1;
	    	//System.out.println(time);
	    	count = 0;
	    }
	}

	private void controllerSorcerer(Input input) {
		black.blackSorcererController(input);
	    white.whiteSorercerController(input);
	}

		 
	private void checkSkillCollision() {
		checkForBlack();
		checkForWhite();
	}


	private void checkForBlack() {
		for(int i = 0 ; i < skill1.size() ; i++){
			Skill temp = skill1.get(i);
			if(white.isCollision(temp)){
				skill1.remove(i);
				numSkill1 --;
			}
			if(map.isCollision(temp)){
				skill1.remove(i);
				numSkill1 --;
			}
		}
	}


	private void checkForWhite() {
		for(int i = 0 ; i < skill2.size() ; i++){
			Skill temp = skill2.get(i);
			if(black.isCollision(temp)){
				skill2.remove(i);
				numSkill2 --;
			}
			if(map.isCollision(temp)){
				skill2.remove(i);
				numSkill2 --;
			}
		}
	}

	
	public void blackSorcererController(Input input) throws SlickException {
			if (input.isKeyPressed(Input.KEY_U)){
				skill1.add(new Fireball(black.x,black.y));
				black.checkTurn(skill1.get(numSkill1));
				numSkill1 ++;
				for (int i = 0;i<skill1.size();i++){
					skill1.get(i).releaseSkill();
					
				}
			}

	}
	
	public void whiteSorcererController(Input input) throws SlickException {
		if (input.isKeyPressed(Input.KEY_Q)){
			skill2.add(new Fireball(white.x,white.y));
			white.checkTurn(skill2.get(numSkill1));
			numSkill2 ++;
			for (int i = 0;i<skill2.size();i++){
				System.out.println(skill2.size());
				skill2.get(i).releaseSkill();
				
			}
		}

}
	
	
	public static void main(String[] args) {
		try {
			  SorcererGame game = new SorcererGame("SorcererGame");
		      AppGameContainer appgc = new AppGameContainer(game);
		      appgc.setDisplayMode(GAME_WIDTH, GAME_HEIGHT, false);
		      
		      appgc.setMinimumLogicUpdateInterval(1000 / 60);
		      appgc.start();
		    } catch (SlickException e) {
		      e.printStackTrace();
		    }
	}
}
