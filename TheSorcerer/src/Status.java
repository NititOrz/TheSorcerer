
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;


public class Status implements Entity{

	private static final int HP_BAR_WIDTH = 128;
	private static final int HP_BAR_HEIGHT = 15;
	private static final int SPACE_NAME = 32;
	private static final int SPACE_HP_BAR = 128;
	public static final int initHP = 100;
	private float x;
	private float y;
	public float hp_white;
	public float hp_black;
	public int Damage = 20;
	public Image hp_frame;
	private Rectangle hp_bar_white;
	private Rectangle hp_bar_black;
	
	
	
	public Status(float x, float y) throws SlickException {
		initHPBar(x, y);
		hp_frame = new Image("res/hpframe.png");
	}

	private void initHPBar(float x, float y) {
		hp_bar_white = new Rectangle(x + SPACE_HP_BAR, y, hp_white/100*HP_BAR_WIDTH, HP_BAR_HEIGHT);		//white
		hp_bar_black = new Rectangle(x + SorcererGame.GAME_WIDTH - 2*SPACE_HP_BAR, y, hp_black/100*HP_BAR_WIDTH, HP_BAR_HEIGHT);		//black
	}
	
	public void setXY(float x, float y) {
		this.x=x;
		this.y=y;
	}
	
	public float getX() {
	    return x;
	}
	 
    public float getY() {
	    return y;
    }
    
    public int getDamage(){
    	return Damage;
    }
    
	@Override
	public void update(int delta) {
		updateWhiteHPBar();
		updateBlackHPBar();
	}

	private void updateBlackHPBar() {
		hp_bar_black = new Rectangle(x + SorcererGame.GAME_WIDTH - 2*SPACE_HP_BAR, y, hp_black/100*HP_BAR_WIDTH, HP_BAR_HEIGHT);
	}

	private void updateWhiteHPBar() {
		hp_bar_white = new Rectangle(x + SPACE_HP_BAR, y, hp_white/100*HP_BAR_WIDTH, HP_BAR_HEIGHT);
	}

	@Override
	public void draw() {
		drawWhiteHPFrame();
		drawBlackHPFrame();
	}

	private void drawBlackHPFrame() {
		hp_frame.draw(x + SorcererGame.GAME_WIDTH - 2*SPACE_HP_BAR ,y);
	}

	private void drawWhiteHPFrame() {
		hp_frame.draw(x + SPACE_HP_BAR,y);
	}

	@Override
	public void draw(Graphics g) {
		drawPlayerName(g);
		fillColorHPBar(g);
	}

	private void fillColorHPBar(Graphics g) {
		g.setColor(new Color(255,100,0));
		g.fill(hp_bar_white);		//white
		g.fill(hp_bar_black);		//black
	}

	private void drawPlayerName(Graphics g) {
		g.setColor(new Color(255,255,255));
		g.drawString("White", x + SPACE_NAME, y);		//white
		g.drawString("Black", x + SorcererGame.GAME_WIDTH - 3*SPACE_NAME, y);		//black
	}

}
