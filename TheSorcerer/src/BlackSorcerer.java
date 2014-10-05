import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;


public class BlackSorcerer extends Sorcerer {

	public BlackSorcerer(float x, float y) throws SlickException {
		super(x, y);
		setImage();
		initImage();
	}

	private void initImage() {
		image = left;
	}

	private void setImage() throws SlickException {
		right = new Image("res/blacksorcerer right.png");
		left = new Image("res/blacksorcerer left.png");
		front = new Image("res/blacksorcerer front.png");
		back = new Image("res/blacksorcerer back.png");
	}

	public void draw(){
		image.draw(x,y);	
	}
	 
	public void blackSorcererController(Input input) {
		turnLeft(input);
		turnRight(input);
		turnUp(input);
		turnDown(input);	
	}

	private void turnDown(Input input) {
		if (input.isKeyDown(Input.KEY_K)) {
			image = front;
			this.y += SORCERER_VELOCITY;
		}
	}

	private void turnUp(Input input) {
		if (input.isKeyDown(Input.KEY_I)) { 
			image = back;
			this.y -= SORCERER_VELOCITY;
		}
	}

	private void turnRight(Input input) {
		if (input.isKeyDown(Input.KEY_L)) {
			image = right;
			this.x += SORCERER_VELOCITY;
		}
	}

	private void turnLeft(Input input) {
		if (input.isKeyDown(Input.KEY_J)) { 
			initImage();
			this.x -= SORCERER_VELOCITY;
		}
	}
	
}

