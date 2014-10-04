import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Map implements Entity{
	
	public static final int WALL_WIDTH = 20;
	private float x;
	private float y;
	private Image background;
	private Image topbottomwall;
	private Image leftrightwall;
	
	public Map(float x, float y) throws SlickException {
		background = new Image("res/background.png");
		topbottomwall = new Image("res/top and bottom wall.png");
		leftrightwall = new Image("res/left and right wall.png");
	    this.setXY(x,y); 
	    
	  }
	
	public float getX() {
	    return x;
	  }
	
	 
    public float getY() {
	    return y;
	  }
	  
	protected void setXY(float x, float y) {
	    this.x = x;
	    this.y = y;
	  }

	 public void draw(){
		background.draw(x,y);
		topbottomwall.draw(x,y);
		topbottomwall.draw(x,y+SorcererGame.GAME_HEIGHT-WALL_WIDTH);
		leftrightwall.draw(x,y);
		leftrightwall.draw(x+SorcererGame.GAME_WIDTH-WALL_WIDTH,y);
	}
	 
	public boolean isCollision(Skill temp) {
		if(temp.x <= Map.WALL_WIDTH){
			return true;
		}
		if(temp.x >= SorcererGame.GAME_WIDTH-WALL_WIDTH-Skill.SKILL_WIDTH){
			return true;
		}
		if(temp.y <= WALL_WIDTH){
			return true;
		}
		if(temp.y >= SorcererGame.GAME_HEIGHT-WALL_WIDTH-Skill.SKILL_HEIGHT){
			return true;
		}
		return false;
	}

	@Override
	public void update(int delta) {
		// TODO Auto-generated method stub
		
	}

	
}
