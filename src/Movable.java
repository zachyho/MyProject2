import org.newdawn.slick.Input;

public class Movable extends Sprite {
	public Movable(String image_src, float x, float y) {
		super(image_src, x, y);
	}
	
	public void moveToDest(int dir) {
		// Translate the direction to an x and y displacement
		float delta_x = 0,
			  delta_y = 0;
		switch (dir) {
			case DIR_LEFT:
				delta_x = -Sprite.SPEED;
				break;
			case DIR_RIGHT:
				delta_x = Sprite.SPEED;
				break;
			case DIR_UP:
				delta_y = -Sprite.SPEED;
				break;
			case DIR_DOWN:
				delta_y = Sprite.SPEED;
				break;
		}
		
		// Make sure the position isn't occupied!
		if (!Loader.isBlocked(getX() + delta_x, getY() + delta_y)) {
			setX(getX() + delta_x);
			setY(getY() + delta_y);
		}
	}
	
	public void onMove() {
		
	}
	
	public void update(Input input, int delta) {
		
	}
	
	
}
