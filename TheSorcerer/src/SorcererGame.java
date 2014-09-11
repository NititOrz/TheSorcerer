import java.util.LinkedList;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;



public class SorcererGame extends BasicGame{
	
	public static final int GAME_WIDTH = 640;
	public static final int GAME_HEIGHT = 480;
	private boolean isStarted;
	private boolean isGameOver;
	private boolean isRestart;

	private LinkedList<Entity> entities ;
	public SorcererGame(String SorcererGame){
		super(SorcererGame);
		entities = new LinkedList<Entity>();
	}
	

	public void render(GameContainer container, Graphics g) throws SlickException {
		for (Entity entity : entities) {
		      entity.draw();
		    }
		
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		entities.add(new Map(0,0));
		entities.add(new WhiteSorcerer(GAME_WIDTH/6-45,GAME_HEIGHT/2-32));
		entities.add(new BlackSorcerer(GAME_WIDTH/6*5,GAME_HEIGHT/2-32));
		
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		for (Entity entity : entities) {
		      entity.update(delta);
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
