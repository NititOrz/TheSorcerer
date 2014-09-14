import org.newdawn.slick.SlickException;


public class Sorcerer implements Entity{
	
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
	  

	private void bgCheck(float x, float y){
		if(x <= Map.WALL_WIDTH){
			this.x=Map.WALL_WIDTH;
		}
		if(x >= SorcererGame.GAME_WIDTH-Map.WALL_WIDTH-SORCERER_WIDTH){
			this.x=SorcererGame.GAME_WIDTH-Map.WALL_WIDTH-SORCERER_WIDTH;
		}
		if(y <= Map.WALL_WIDTH){
			this.y=Map.WALL_WIDTH;
		}
		if(y >= SorcererGame.GAME_HEIGHT-Map.WALL_WIDTH-SORCERER_HEIGHT){
			this.y=SorcererGame.GAME_HEIGHT-Map.WALL_WIDTH-SORCERER_HEIGHT;
		}
		
	}

	
	@Override
	public void update(int delta) {
		bgCheck(this.x,this.y);
	}


	public void draw() {
		// TODO Auto-generated method stub
		
	}

	
	
}


