import org.newdawn.slick.Graphics;




public interface Entity {
	void update(int delta);
	void draw(Graphics g);
	void draw();
}
