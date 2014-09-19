import java.util.ArrayList;
import java.util.LinkedList;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;



public class SorcererGame extends BasicGame{
	
	public static final int GAME_WIDTH = 640;
	public static final int GAME_HEIGHT = 480;
	public static final int SKILL1_VELOCITY = 10;
	private int i ;
	public int count = 0,time = 0;
	private int positionskill = 0;
	public Sorcerer white;
	public Sorcerer black;
	public Sorcerer sorcerer;
	private boolean isStarted;
	private boolean isGameOver;
	private boolean isRestart;
	
	private ArrayList<Skill> skill1 = new ArrayList<Skill>();
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
		settingSkill();
		settingRelease();
		entities.add(new Map(0,0));
		entities.add(white);
		entities.add(black);
		
		
	}


	private void settingRelease(){

		for (Skill skill : skill1) {
		      skill.isrelease = false;
		    }
		
	}
	public void settingSkill() {
		for (Skill skill : skill1) {
		skill.isturnleft = false;
		skill.isturndown = false;
		skill.isturnright = false;
		skill.isturnup = false;
		}
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		Input input = container.getInput();
	    updateSorcererMovement(input, delta);
	    checkSkillCollision();
	    count += delta;
	    if(count >= 1000){
	    	time += 1;
	    	System.out.println(time);
	    	count = 0;
	    }
	    checkTurn();
	    for (Entity entity : entities) {
		      entity.update(delta);
		    }
	    for (Skill skill : skill1) {
		      skill.update(delta);
		    }
		
	}

		 
	private void checkSkillCollision() {
		for(i = 0 ; i < skill1.size() ; i++){
			Skill temp = skill1.get(i);
			if(white.isCollision(temp)){
				skill1.remove(i);
			}
		}
	}
	
		void updateSorcererMovement(Input input, int delta) throws SlickException {
		
	    whiteSorercerController(input);
		blackSorcererController(input);
		
	}

		public void checkTurn(){
			if(black.image == black.left){
				for (Skill skill : skill1) {
					  skill.isturnleft = true;
				}
			}
			if(black.image == black.right){
				for (Skill skill : skill1) {
					  skill.isturnright = true;
				}
			}
			if(black.image == black.back){
				for (Skill skill : skill1) {
					  skill.isturnup = true;
				}
			}
			if(black.image == black.front){
				for (Skill skill : skill1) {
					  skill.isturndown = true;
				}
			}
		}

		public void blackSorcererController(Input input) throws SlickException {
			if (input.isKeyDown(Input.KEY_J)) { 
			  black.turnLeft();
			}
			if (input.isKeyDown(Input.KEY_L)) {
			  black.turnRight();
			}
			if (input.isKeyDown(Input.KEY_I)) { 
			  black.turnUp();
			}
			if (input.isKeyDown(Input.KEY_K)) {
			  black.turnDown();
			}
			if (input.isKeyPressed(Input.KEY_U)){
				skill1.add(new Fireball(black.x,black.y));
				for (Skill skill : skill1) {
				skill.isrelease = true;
				}
			}

		}

		
		public void whiteSorercerController(Input input) {
			if (input.isKeyDown(Input.KEY_A)) { 
			  white.turnLeft();
			}
			if (input.isKeyDown(Input.KEY_D)) {
			  white.turnRight();
			}
			if (input.isKeyDown(Input.KEY_W)) { 
			  white.turnUp();
			}
			if (input.isKeyDown(Input.KEY_S)) {
			  white.turnDown();
			}
		}
	
	

		
		
	public static void main(String[] args) {
		try {
			  SorcererGame game = new SorcererGame("SorcererGame");
		      AppGameContainer appgc = new AppGameContainer(game);
		      appgc.setDisplayMode(640, 480, false);
		      
		      appgc.setMinimumLogicUpdateInterval(1000 / 60);
		      appgc.start();
		    } catch (SlickException e) {
		      e.printStackTrace();
		    }
	}
}
