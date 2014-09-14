import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class BlackSorcerer extends Sorcerer {

	Image right,left,front,back,image;
	
	
	public BlackSorcerer(float x, float y) throws SlickException {
		super(x, y);
		right = new Image("res/blacksorcerer right.png");
		left = new Image("res/blacksorcerer left.png");
		front = new Image("res/blacksorcerer front.png");
		back = new Image("res/blacksorcerer back.png");
		image = left;
	}

	 public void draw(){
			image.draw(x,y);
		}
	 
	 
	 public void turnLeft() {
	      x -= 2;
	      image = left;
	 }

	 public void turnRight(){
		 x += 2;
		 image = right;
	 }

	 public void turnUp(){
		 y -= 2;
		 image = back;
	 }

	 public void turnDown(){
		 y += 2;
		 image = front;
	 }
	 
	 
}

