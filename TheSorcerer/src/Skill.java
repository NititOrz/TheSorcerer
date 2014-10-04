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
	protected float SKILL_WIDTH = 32;
	protected float SKILL_HEIGHT = 24;
	protected static final float SKILL_VELOCITY = 10;
	

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
    
    /*public void checkBlackTurn(){
    	if(game.black.image == game.black.left){
    		isturnleft = true;
    	}
    	else if(game.black.image == game.black.right){
    		isturnright = true;
    	}
    	else if(game.black.image == game.black.back){
    		isturnup = true;
    	}
    	else if(game.black.image == game.black.front){
    		isturndown = true;
    	}
    }*/
    
    public void releaseSkill(){
    		if(isturnleft){
    			x -= SKILL_VELOCITY;
    		}
    		else if(isturnright){
    			x += SKILL_VELOCITY;
    		}
    		else if(isturndown){
    			y += SKILL_VELOCITY;
    		}
    		else if(isturnup){
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
