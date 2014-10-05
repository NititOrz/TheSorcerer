import org.newdawn.slick.Graphics;
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
		initImage();
	    this.setXY(x,y);  
	}

	private void initImage() throws SlickException {
		background = new Image("res/background.png");
		topbottomwall = new Image("res/top and bottom wall.png");
		leftrightwall = new Image("res/left and right wall.png");
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
		topbottomwall.draw(x ,y);		//draw top wall
		topbottomwall.draw(x ,y + SorcererGame.GAME_HEIGHT-WALL_WIDTH - SorcererGame.STATUS_SPACE);		//draw bottom wall
		leftrightwall.draw(x ,y);		//draw left wall
		leftrightwall.draw(x + SorcererGame.GAME_WIDTH-WALL_WIDTH ,y);		//draw right wall
	}
	 
	public boolean isCollision(Skill temp) {
		if(temp.x <= Map.WALL_WIDTH){		//left wall
			return true;
		}
		if(temp.x >= SorcererGame.GAME_WIDTH - WALL_WIDTH-Skill.SKILL_WIDTH){		//right wall
			return true;
		}
		if(temp.y <= WALL_WIDTH + SorcererGame.STATUS_SPACE){		//top wall
			return true;
		}
		if(temp.y >= SorcererGame.GAME_HEIGHT-WALL_WIDTH - Skill.SKILL_HEIGHT){		//bottom wall
			return true;
		}
		
		return false;
	}

	
	@Override
	public void update(int delta) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	
}
