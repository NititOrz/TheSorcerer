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
	private int numSkill = 0;;
	private boolean isStarted;
	private boolean isGameOver;
	private boolean isRestart;
	
	
	public ArrayList<Skill> skill1 = new ArrayList<Skill>();
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
		
	}

	
	@Override
	public void init(GameContainer container) throws SlickException {
		white = new WhiteSorcerer(GAME_WIDTH/6-45,GAME_HEIGHT/2-32);
		black = new BlackSorcerer(GAME_WIDTH/6*5,GAME_HEIGHT/2-32);
		map = new Map(0,0);
		entities.add(new Map(0,0));
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
	    Input input = container.getInput();
	    controllerSorcerer(input);
	    blackSorcererController(input);
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
		for(int i = 0 ; i < skill1.size() ; i++){
			Skill temp = skill1.get(i);
			if(white.isCollision(temp)){
				skill1.remove(i);
				numSkill --;
			}
			if(map.isCollision(temp)){
				skill1.remove(i);
				numSkill --;
			}
		}
	}
	
	
	public void checkTurn(Skill skill){
			if(black.image == black.left){
					  skill.isturnleft = true;
			}
			if(black.image == black.right){
					  skill.isturnright = true;
			}
			if(black.image == black.back){
					  skill.isturnup = true;
			}
			if(black.image == black.front){
					  skill.isturndown = true;
			}
	}

	
	public void blackSorcererController(Input input) throws SlickException {
			if (input.isKeyPressed(Input.KEY_U)){
				skill1.add(new Fireball(black.x,black.y));
				checkTurn(skill1.get(numSkill));
				numSkill ++;
				for (int i = 0;i<skill1.size();i++){
					skill1.get(i).releaseSkill();
					
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
