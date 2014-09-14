import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class WhiteSorcerer extends Sorcerer {

	Image right,left,front,back,image;
	
	
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
	 
	 /*public void SorcererCheck(){
			if(this.x <= getX()+SORCERER_WIDTH && this.x >= getX()+1){
				System.out.println("Colision");
			}
		}
	 
	 public void update(int delta) {
		 SorcererCheck();
		}*/
}
