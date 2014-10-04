import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Skill implements Entity{

	protected Image image;
	protected SorcererGame game;
	protected Sorcerer sorcerer;
	protected boolean cooldown;
	protected float x;
	protected float y;
	public boolean isrelease = false;
	public boolean isturnleft ,isturnright ,isturnup ,isturndown;
	public static final float SKILL_WIDTH = 32;
	public static final float SKILL_HEIGHT = 24;
	public static final float SKILL_VELOCITY = 10;
	

	public Skill(float x, float y) throws SlickException {
	    this.setXY(x,y); 
	  }
	
	protected void setXY(float x, float y) {
		this.x=x;
		this.y=y;
		
	}
	
	protected float getX() {
	    return x;
	  }
	
	 
    protected float getY() {
	    return y;
	 }
    
    public void releaseSkill(){
    		if(isturnleft){
    			image.setRotation(180);
    			x -= SKILL_VELOCITY;
    		}
    		else if(isturnright){
    			image.setRotation(0);
    			x += SKILL_VELOCITY;
    		}
    		else if(isturndown){
    			image.setRotation(90);
    			y += SKILL_VELOCITY;
    		}
    		else if(isturnup){
    			image.setRotation(270);
    			y -= SKILL_VELOCITY;
    	}
    }
	
	@Override
	public void update(int delta) {
		releaseSkill();
	}

	public void draw() {
		// TODO Auto-generated method stub
		
	}
    

}
