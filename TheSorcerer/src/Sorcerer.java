import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Sorcerer implements Entity{
	
	
	protected static final int SORCERER_VELOCITY = 3;
	protected Image right,left,front,back,image;
	protected Skill skill;
	protected float x;
	protected float y;
	public static final int SORCERER_HEIGHT = 60;
	public static final int SORCERER_WIDTH = 48;
	
	
	public Sorcerer(float x, float y) throws SlickException {
	    this.setXY(x,y); 
	}
	
	protected void setXY(float x, float y) {
	    this.x = x;
	    this.y = y;
	}
	
	
	protected float getX() {
	    return x;
	}
	
	 
	protected float getY() {
	    return y;
	}
	  

	public void bgCheck(float x, float y){
		if(x <= Map.WALL_WIDTH){
			this.x=Map.WALL_WIDTH;
		}
		if(x >= SorcererGame.GAME_WIDTH - Map.WALL_WIDTH - SORCERER_WIDTH){
			this.x=SorcererGame.GAME_WIDTH - Map.WALL_WIDTH - SORCERER_WIDTH;
		}
		if(y <= Map.WALL_WIDTH + SorcererGame.STATUS_SPACE){
			this.y=Map.WALL_WIDTH + SorcererGame.STATUS_SPACE;
		}
		if(y >= SorcererGame.GAME_HEIGHT - Map.WALL_WIDTH - SORCERER_HEIGHT){
			this.y=SorcererGame.GAME_HEIGHT - Map.WALL_WIDTH - SORCERER_HEIGHT;
		}
		
	}
	
	@Override
	public void update(int delta) {
		bgCheck(this.x,this.y);
	}


	public void draw() {
		
	}

	
	public boolean isCollision(Skill temp) {
		if(Math.abs((x+SORCERER_WIDTH/2) - (temp.x+Skill.SKILL_WIDTH/2)) < SORCERER_WIDTH/2 && Math.abs((y+SORCERER_HEIGHT/2) - (temp.y+Skill.SKILL_HEIGHT/2)) < SORCERER_HEIGHT/2){
			return true;
			}
			return false;
	}

	protected void checkTurn(Skill skill){
			if(image == left){
					  skill.isturnleft = true;
			}
			if(image == right){
					  skill.isturnright = true;
			}
			if(image == back){
					  skill.isturnup = true;
			}
			if(image == front){
					  skill.isturndown = true;
			}
	}

	
}


