import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Sorcerer implements Entity{
	
	
	protected static final int SORCERER_VELOCITY = 3;
	protected Image right,left,front,back,image;
	protected Skill skill;
	protected float x;
	protected float y;
	protected int hp = 0;
	protected Status status;
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
	
	protected void setHP(){
		 hp = Status.initHP;
	}
	  
	public void bgCheck(float x, float y){
		isCollideLeftWall(x);
		isCollideRightWall(x);
		isCollideTopWall(y);
		isCollideBottomWalll(y);
		
	}

	private void isCollideBottomWalll(float y) {
		if(y >= SorcererGame.GAME_HEIGHT - Map.WALL_WIDTH - SORCERER_HEIGHT){
			this.y=SorcererGame.GAME_HEIGHT - Map.WALL_WIDTH - SORCERER_HEIGHT;
		}
	}

	private void isCollideTopWall(float y) {
		if(y <= Map.WALL_WIDTH + SorcererGame.STATUS_SPACE){
			this.y=Map.WALL_WIDTH + SorcererGame.STATUS_SPACE;
		}
	}

	private void isCollideRightWall(float x) {
		if(x >= SorcererGame.GAME_WIDTH - Map.WALL_WIDTH - SORCERER_WIDTH){
			this.x=SorcererGame.GAME_WIDTH - Map.WALL_WIDTH - SORCERER_WIDTH;
		}
	}

	private void isCollideLeftWall(float x) {
		if(x <= Map.WALL_WIDTH){
			this.x=Map.WALL_WIDTH;
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
			isTurnLeft(skill);
			isTurnRight(skill);
			isTurnUp(skill);
			isTurnDown(skill);
	}

	private void isTurnDown(Skill skill) {
		if(image == front){
				  skill.isturndown = true;
		}
	}

	private void isTurnUp(Skill skill) {
		if(image == back){
				  skill.isturnup = true;
		}
	}

	private void isTurnRight(Skill skill) {
		if(image == right){
				  skill.isturnright = true;
		}
	}

	private void isTurnLeft(Skill skill) {
		if(image == left){
				  skill.isturnleft = true;
		}
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	
}


