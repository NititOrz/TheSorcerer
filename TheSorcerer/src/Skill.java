import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Skill implements Entity{

	protected Image image;
	protected SorcererGame sorcerer;
	protected boolean cooldown;
	protected float x;
	protected float y;
	public boolean isrelease,isturnleft,isturnright,isturnup,isturndown;
	public float velocity = SorcererGame.SKILL1_VELOCITY;
	

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

    
	protected void release() {
		if(isturnleft){
	      x -= velocity;
		}
		if(isturnright){
	      x += velocity;
		}
		if(isturnup){
	      y -= velocity;
		}
		if(isturndown){
	      y += velocity;
		}
	 }
	 
	
	@Override
	public void update(int delta) {
		if(isrelease){
		release();
		}
		else{
			isturnleft = false;
			isturnright = false;
			isturnup = false;
			isturndown = false;
		}
	}

	public void draw() {
		// TODO Auto-generated method stub
		
	}
    

}
