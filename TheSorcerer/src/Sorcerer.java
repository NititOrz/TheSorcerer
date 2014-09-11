import org.newdawn.slick.SlickException;


public class Sorcerer implements Entity{
	
	protected float x;
	protected float y;
	
	public Sorcerer(float x, float y) throws SlickException {
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

	}

	@Override
	public void update(int delta) {
		// TODO Auto-generated method stub
		
	}

	
}


