import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class WhiteSorcerer extends Sorcerer {

	public static float wx , wy;
	
	
	public WhiteSorcerer(float x, float y) throws SlickException {
		super(x, y);
		right = new Image("res/whitesorcerer right.png");
		left = new Image("res/whitesorcerer left.png");
		front = new Image("res/whitesorcerer front.png");
		back = new Image("res/whitesorcerer back.png");
		image = right;
		// TODO Auto-generated constructor stub
	}
	
	 public void draw(){
			image.draw(x,y);
		}
	 
}
