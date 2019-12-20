package com.bakerystudios.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.List;

import com.bakerystudios.engine.Renderable;
import com.bakerystudios.engine.Updateble;
import com.bakerystudios.engine.camera.Camera;
import com.bakerystudios.engine.graphics.engine.Spritesheet;
import com.bakerystudios.engine.graphics.engine.Tile;
import com.bakerystudios.engine.graphics.engine.World;
import com.bakerystudios.game.screen.Screen;

public class Player extends Entity implements Renderable, Updateble {

	private int movingFrames = 0, maxMovingFrames = 16;
	private boolean movingRight;
	private boolean movingLeft;
	private boolean movingUp;
	private boolean movingDown;

	private int frames = 0, maxFrames = 5, index = 0, maxIndex = 2;
	private boolean moved = false;
	private final int RIGHT_DIR = 0, LEFT_DIR = 1, UP_DIR = 2, DOWN_DIR = 3;
	private int dir = LEFT_DIR;
	protected static boolean right, left, up, down;

	private double speed = 1.0;

	private BufferedImage[] rightSprite;
	private BufferedImage[] leftSprite;
	private BufferedImage[] downSprite;
	private BufferedImage[] upSprite;
	
	private Camera camera;

	public Player(int x, int y, int width, int height, BufferedImage sprite, Spritesheet characters) {
		super(x, y, width, height, sprite);

		camera = new Camera(0, 0);
		
		rightSprite = new BufferedImage[3];
		leftSprite = new BufferedImage[3];
		downSprite = new BufferedImage[3];
		upSprite = new BufferedImage[3];

		for (int i = 0; i < 3; i++) {
			downSprite[i] = characters.getSprite(48 + (i * 16), 0, 16, 16);
			leftSprite[i] = characters.getSprite(48 + (i * 16), 16, 16, 16);
			rightSprite[i] = characters.getSprite(48 + (i * 16), 32, 16, 16);
			upSprite[i] = characters.getSprite(48 + (i * 16), 48, 16, 16);
		}
	}
	
	public void moving() {
		if (movingRight) {
			movingFrames++;
			x += speed;
			if (movingFrames >= maxMovingFrames) {
				movingFrames = 0;
				movingRight = false;
				moved = false;
			}
		}
		if (movingLeft) {
			movingFrames++;
			x -= speed;
			if (movingFrames >= maxMovingFrames) {
				movingFrames = 0;
				movingLeft = false;
				moved = false;
			}
		}
		if (movingUp) {
			movingFrames++;
			y -= speed;
			if (movingFrames >= maxMovingFrames) {
				movingFrames = 0;
				movingUp = false;
				moved = false;
			}
		}
		if (movingDown) {
			movingFrames++;
			y += speed;
			if (movingFrames >= maxMovingFrames) {
				movingFrames = 0;
				movingDown = false;
				moved = false;
			}
		}
	}

	public void animation() {
		if (moved) {
			frames++;
			if (frames == maxFrames) {
				frames = 0;
				index++;
				if (index > maxIndex)
					index = 0;
			}
		} else {
			index = 1;
		}
	}

	public void update(List<World> world, Screen screen, int CUR_MAP) {
		moving();
		animation();
		updateCamera(world, CUR_MAP, screen);
	}

	public void render(Graphics g) {
//		g.setColor(Color.red);
//		g.fillRect((int) x - Camera.x, (int) y - Camera.y, 16, 16);

		if (dir == RIGHT_DIR) {
			g.drawImage(rightSprite[index], this.getX() - camera.getX(), this.getY() - camera.getY(), null);

		} else if (dir == LEFT_DIR) {
			g.drawImage(leftSprite[index], this.getX() - camera.getX(), this.getY() - camera.getY(), null);

		} else if (dir == UP_DIR) {
			g.drawImage(upSprite[index], this.getX() - camera.getX(), this.getY() - camera.getY(), null);

		} else if (dir == DOWN_DIR) {
			g.drawImage(downSprite[index], this.getX() - camera.getX(), this.getY() - camera.getY(), null);

		}
	}

	public void updateCamera(List<World> world, int CUR_MAP, Screen screen) {
		camera.setX(camera.clamp(this.getX() - (screen.getWIDTH() / 2), 0,
				world.get(CUR_MAP).getWIDTH() * Tile.SIZE - screen.getWIDTH()));
		camera.setY(camera.clamp(this.getY() - (screen.getHEIGHT() / 2), 0,
				world.get(CUR_MAP).getHEIGHT() * Tile.SIZE - screen.getHEIGHT()));
	}

	public boolean isRight() {
		return right;
	}

	public static void setUp(boolean up) {
		Player.up = up;
	}

	public static void setDown(boolean down) {
		Player.down = down;
	}

	public static void setLeft(boolean left) {
		Player.left = left;
	}

	public static void setRight(boolean right) {
		Player.right = right;
	}

	public int getDir() {
		return dir;
	}

	public void setDir(int dir) {
		this.dir = dir;
	}

	public Camera getCamera() {
		return camera;
	}

	public void setCamera(Camera camera) {
		this.camera = camera;
	}

}
