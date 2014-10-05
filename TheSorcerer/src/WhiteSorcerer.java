import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;


public class WhiteSorcerer extends Sorcerer {
	
	public WhiteSorcerer(float x, float y) throws SlickException {
		super(x, y);
		setImage();
		initImage();
		// TODO Auto-generated constructor stub
	}

	private void initImage() {
		image = right;
	}

	private void setImage() throws SlickException {
		right = new Image("res/whitesorcerer right.png");
		left = new Image("res/whitesorcerer left.png");
		front = new Image("res/whitesorcerer front.png");
		back = new Image("res/whitesorcerer back.png");
	}
	
	public void draw(){
		image.draw(x,y);
	}
	
	public void whiteSorercerController(Input input) {
		turnLeft(input);
		turnRight(input);
		turnUp(input);
		turnDown(input);
	}

	private void turnDown(Input input) {
		if (input.isKeyDown(Input.KEY_S)) {
			image = front;
			this.y += SORCERER_VELOCITY;
		}
	}

	private void turnUp(Input input) {
		if (input.isKeyDown(Input.KEY_W)) { 
			image = back;
			this.y -= SORCERER_VELOCITY;
		}
	}

	private void turnRight(Input input) {
		if (input.isKeyDown(Input.KEY_D)) {
			initImage();
			this.x += SORCERER_VELOCITY;
		}
	}

	private void turnLeft(Input input) {
		if (input.isKeyDown(Input.KEY_A)) { 
			image = left;
			this.x -= SORCERER_VELOCITY;
		}
	}
}
