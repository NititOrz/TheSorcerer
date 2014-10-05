import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Status implements Entity{

	public static final int initHP = 100;
	public int Damage = 20;
	public Image hp_frame;
	public Image hp_bar;
	private float x;
	private float y;
	
	public Status(float x, float y) throws SlickException {
		hp_frame = new Image("res/hpframe.png");
		hp_bar = new Image("res/hpbar.png");
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw() {
	hp_bar.draw(x + 128,y);
	hp_frame.draw(x + 128,y);
	
	}

	@Override
	public void draw(Graphics g) {
		g.drawString("Player 1", x + 32, y);
	}

}
