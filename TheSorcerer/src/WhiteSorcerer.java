import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class WhiteSorcerer extends Sorcerer {

	Image image ;
	
	
	public WhiteSorcerer(float x, float y) throws SlickException {
		super(x, y);
		image = new Image("res/whitesorcerer right.png");
		// TODO Auto-generated constructor stub
	}

	 public void draw(){
			image.draw(x,y);
		}
}
