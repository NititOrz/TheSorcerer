import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Fireball extends Skill {

	public Fireball(float x, float y) throws SlickException {
		super(x, y);
		image = new Image("res/fireball.png");
		// TODO Auto-generated constructor stub
	}
	
	public void draw() {
		if(isrelease)
		image.draw(x,y);
	}

}
