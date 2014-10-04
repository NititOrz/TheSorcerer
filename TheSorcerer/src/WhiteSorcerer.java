import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
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
	 
	 public void whiteSorercerController(Input input) {
			if (input.isKeyDown(Input.KEY_A)) { 
			  image = left;
			  this.x -= SORCERER_VELOCITY;
			}
			if (input.isKeyDown(Input.KEY_D)) {
			  image = right;
			  this.x += SORCERER_VELOCITY;
			}
			if (input.isKeyDown(Input.KEY_W)) { 
			  image = back;
			  this.y -= SORCERER_VELOCITY;
			}
			if (input.isKeyDown(Input.KEY_S)) {
			  image = front;
			  this.y += SORCERER_VELOCITY;
			}
	}
}
