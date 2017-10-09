

import org.newdawn.slick.Input;

public class Player extends Movable {
	
	public Player(float x, float y) {
		super("res/player_left.png", x, y);
	}

	@Override
	public void update(Input input, int delta) {
		int dir = DIR_NONE;

		if (input.isKeyPressed(Input.KEY_LEFT)) {
			dir = DIR_LEFT;
		}
		else if (input.isKeyPressed(Input.KEY_RIGHT)) {
			dir = DIR_RIGHT;
		}
		else if (input.isKeyPressed(Input.KEY_UP)) {
			dir = DIR_UP;
		}
		else if (input.isKeyPressed(Input.KEY_DOWN)) {
			dir = DIR_DOWN;
		}
		
		// Move to our destination
		moveToDest(dir);
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
}
