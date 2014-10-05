import java.util.ArrayList;
import java.util.LinkedList;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;



public class SorcererGame extends BasicGame{
	
	
	public static final int STATUS_SPACE = 40;
	public static final int GAME_WIDTH = 1024;
	public static final int GAME_HEIGHT = 640;
	public WhiteSorcerer white;
	public BlackSorcerer black;
	public Sorcerer sorcerer;
	public Map map;
	public TimeMagement time;
	public Status status;
	public int whiteHP;
	public int blackHP;
	private int numSkill1 = 0;
	private int numSkill2 = 0;
	private boolean isStart;
	private boolean isGameOver;
	private String winner ;
	
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
		drawReGameScreen(g);
	}
	
	
	private void drawReGameScreen(Graphics g) {
		if(isGameOver){
			drawBG(g);
			detail(g);
		}
	}

	private void detail(Graphics g) {
		g.setColor(new Color(0,0,0));
		g.drawString(winner + " WIN!!", GAME_WIDTH/2-50, GAME_HEIGHT/2-20);
		g.drawString("Again?", GAME_WIDTH/2-25, GAME_HEIGHT/2+20);
		g.drawString("Enter Please.", GAME_WIDTH/2-55, GAME_HEIGHT/2+60);
	}

	private void drawBG(Graphics g) {
		g.setColor(new Color(90,255,255));		//set BG color
		Rectangle restart_screen;
		restart_screen = new Rectangle(0,0,GAME_WIDTH,GAME_HEIGHT);
		g.fill(restart_screen);
	}

	
	@Override
	public void init(GameContainer container) throws SlickException {
		inition();
		setInitPlayerHP();
		addEntity();
		setGameStatus();
	}

	
	private void setGameStatus() {
		isStart = true;
		isGameOver = false;
	}

	private void inition() throws SlickException {
		white = new WhiteSorcerer(GAME_WIDTH/6 - 45 ,GAME_HEIGHT/2 - 32);
		black = new BlackSorcerer(GAME_WIDTH/6 * 5,GAME_HEIGHT/2 - 32);
		map = new Map(0 ,STATUS_SPACE);
		status = new Status(0,0);
		time = new TimeMagement(0,0);
	}

	private void addEntity() {
		entities.add(status);
		entities.add(time);
		entities.add(map);
		entities.add(white);
		entities.add(black);
	}

	private void setInitPlayerHP() {
		white.setHP();
		black.setHP();
	}

	
	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		if(isStart){
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
		}
		updatePlayerHP();
		sendUpdatePlayerHPToStatus();
		checkGameOver(container);
		checkTimer();
	}


	private void checkTimer() {
		if(time.timer == 0){
			isGameOver = true;
		}
	}

	private void sendUpdatePlayerHPToStatus() {
		status.hp_white = whiteHP;
		status.hp_black = blackHP;
	}

	private void updatePlayerHP() {
		whiteHP = white.getHP();
		blackHP = black.getHP();
	}


	private void checkGameOver(GameContainer container) throws SlickException {
		if(isGameOver){
			Input input = container.getInput();
			isStart = false;
			restartGame(container, input);
		}
	}

	private void restartGame(GameContainer container, Input input)throws SlickException {
		if(input.isKeyPressed(Input.KEY_ENTER)){
			setGameStatus();
			input.clearKeyPressedRecord();
			container.reinit();
		}
	}

	
	private void controllerSorcerer(Input input) {
		black.blackSorcererController(input);
	    white.whiteSorercerController(input);
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
			if(white.hp == 0){
				winner = "Black";
				isGameOver = true;
			}
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
			if(black.hp == 0){
				winner = "White";
				isGameOver = true;
			}
			//System.out.println(black.hp);
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
