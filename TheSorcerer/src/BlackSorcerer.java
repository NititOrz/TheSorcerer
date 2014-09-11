import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class BlackSorcerer extends Sorcerer {
Image image ;
	
	
	public BlackSorcerer(float x, float y) throws SlickException {
		super(x, y);
		image = new Image("res/blacksorcerer left.png");
		// TODO Auto-generated constructor stub
	}

	 public void draw(){
			image.draw(x,y);
		}
}
