import java.util.ArrayList;
import java.util.LinkedList;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;



public class SorcererGame extends BasicGame{
	
	
	public static final int STATUS_SPACE = 40;
	public static final int GAME_WIDTH = 1024;
	public static final int GAME_HEIGHT = 640;
	public WhiteSorcerer white;
	public BlackSorcerer black;
	public Sorcerer sorcerer;
	public Map map;
	public TimeMagement time;
	protected Status status;
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
		      entity.draw(g);
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
		inition();
		addEntity();
		setPlayerHP();
		
		
	}


	private void inition() throws SlickException {
		white = new WhiteSorcerer(GAME_WIDTH/6 - 45 ,GAME_HEIGHT/2 - 32);
		black = new BlackSorcerer(GAME_WIDTH/6 * 5,GAME_HEIGHT/2 - 32);
		map = new Map(0 ,STATUS_SPACE);
		status = new Status(0,0);
		time = new TimeMagement();
	}


	private void addEntity() {
		entities.add(status);
		entities.add(time);
		entities.add(map);
		entities.add(white);
		entities.add(black);
	}


	private void setPlayerHP() {
		white.setHP();
		black.setHP();
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
	    time.timeCounter(delta);
	    Input input = container.getInput();
	    controllerSorcerer(input);
	    blackSorcererController(input);
	    whiteSorcererController(input);
	    checkSkillCollision();
		
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
			removeSkillWhenCollideWhite(i, temp);
			removeSkillWhenCollideWallForBlack(i, temp);
		}
	}


	private void removeSkillWhenCollideWallForBlack(int i, Skill temp) {
		if(map.isCollision(temp)){
			skill1.remove(i);
			numSkill1 --;
		}
	}


	private void removeSkillWhenCollideWhite(int i, Skill temp) {
		if(white.isCollision(temp)){
			skill1.remove(i);
			numSkill1 --;
			white.hp = white.hp - status.Damage;
			//System.out.println(white.hp);
		}
	}


	private void checkForWhite() {
		for(int i = 0 ; i < skill2.size() ; i++){
			Skill temp = skill2.get(i);
			removeSkillWhenCollideBlack(i, temp);
			removeSkillWhenCollideWallForWhite(i, temp);
		}
	}


	private void removeSkillWhenCollideWallForWhite(int i, Skill temp) {
		if(map.isCollision(temp)){
			skill2.remove(i);
			numSkill2 --;
		}
	}


	private void removeSkillWhenCollideBlack(int i, Skill temp) {
		if(black.isCollision(temp)){
			skill2.remove(i);
			numSkill2 --;
			black.hp = black.hp - status.Damage;
			//System.out.println(black.hp);
		}
	}

	
	public void blackSorcererController(Input input) throws SlickException {
			if (input.isKeyPressed(Input.KEY_U)){
					skill1.add(new Fireball(black.x,black.y));
					time.skill1DelayCheck(skill1.get(numSkill1));
					black.checkTurn(skill1.get(numSkill1));
					numSkill1 ++;
					for (int i = 0;i<skill1.size();i++){ //release skill
						skill1.get(i).releaseSkill();
					}
			}

	}
	
	public void whiteSorcererController(Input input) throws SlickException {
		if (input.isKeyPressed(Input.KEY_Q)){
			skill2.add(new Fireball(white.x,white.y));
			time.skill2DelayCheck(skill2.get(numSkill2));
			white.checkTurn(skill2.get(numSkill2));
			numSkill2 ++;
			for (int i = 0;i<skill2.size();i++){
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
