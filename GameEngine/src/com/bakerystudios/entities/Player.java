package com.bakerystudios.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.bakerystudios.engine.Renderable;
import com.bakerystudios.engine.Updateble;
import com.bakerystudios.engine.camera.Camera;
import com.bakerystudios.engine.graphics.engine.Tile;
import com.bakerystudios.game.Game;
import com.bakerystudios.game.screen.Screen;

public class Player extends Entity implements Renderable, Updateble {

	private int movingFrames = 0, maxMovingFrames = 16;
	private boolean movingRight;
	private boolean movingLeft;
	private boolean movingUp;
	private boolean movingDown;

	private int frames = 0, maxFrames = 5, index = 0, maxIndex = 2;
	private boolean moved = false;
	public static final int RIGHT_DIR = 0, LEFT_DIR = 1, UP_DIR = 2, DOWN_DIR = 3;
	private int dir = LEFT_DIR;
	protected static boolean right, left, up, down;

	public static boolean usedAlavanca = false;
	public boolean florestEvent;

	private double speed = 1.0;

	private BufferedImage[] rightSprite;
	private BufferedImage[] leftSprite;
	private BufferedImage[] downSprite;
	private BufferedImage[] upSprite;

	public static int controllerInventory = 1; // 1 para Inventario - 2 para Bau

	public Player(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);

		rightSprite = new BufferedImage[3];
		leftSprite = new BufferedImage[3];
		downSprite = new BufferedImage[3];
		upSprite = new BufferedImage[3];

		for (int i = 0; i < 3; i++) {
			downSprite[i] = Game.characters.getSprite(48 + (i * 16), 0, 16, 16);
			leftSprite[i] = Game.characters.getSprite(48 + (i * 16), 16, 16, 16);
			rightSprite[i] = Game.characters.getSprite(48 + (i * 16), 32, 16, 16);
			upSprite[i] = Game.characters.getSprite(48 + (i * 16), 48, 16, 16);
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

	public void update() {
		moving();
		animation();
		updateCamera();

		if (x == 896 && y == 624) {
			florestEvent = true;
			movingLeft = true;
			moved = true;
			dir = LEFT_DIR;
			Game.gameEvent = true;
		}
	}

	public void render(Graphics g) {
//		g.setColor(Color.red);
//		g.fillRect((int) x - Camera.x, (int) y - Camera.y, 16, 16);

		if (dir == RIGHT_DIR) {
			g.drawImage(rightSprite[index], this.getX() - Camera.x, this.getY() - Camera.y, null);

		} else if (dir == LEFT_DIR) {
			g.drawImage(leftSprite[index], this.getX() - Camera.x, this.getY() - Camera.y, null);

		} else if (dir == UP_DIR) {
			g.drawImage(upSprite[index], this.getX() - Camera.x, this.getY() - Camera.y, null);

		} else if (dir == DOWN_DIR) {
			g.drawImage(downSprite[index], this.getX() - Camera.x, this.getY() - Camera.y, null);

		}
	}

	public void updateCamera() {
		Camera.x = Camera.clamp(this.getX() - (Screen.WIDTH / 2), 0,
				Game.world.get(Game.CUR_MAP).WIDTH * Tile.SIZE - Screen.WIDTH);
		Camera.y = Camera.clamp(this.getY() - (Screen.HEIGHT / 2), 0,
				Game.world.get(Game.CUR_MAP).HEIGHT * Tile.SIZE - Screen.HEIGHT);
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

}
