package com.bakerystudios.engine.graphics.engine;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.bakerystudios.engine.camera.Camera;
import com.bakerystudios.game.Game;

public class Tile {
	
	public static final int SIZE = 16; 
	
	public static BufferedImage TILE_FLOOR = Game.spritesheet.getSprite(0,0,SIZE,SIZE);
	public static BufferedImage TILE_WALL = Game.spritesheet.getSprite(16,0,SIZE,SIZE);
	
	private BufferedImage sprite;
	private int x, y;
	
	public Tile(int x,int y,BufferedImage sprite){
		this.x = x;
		this.y = y;
		this.sprite = sprite;
	}
	
	public void render(Graphics g, Camera camera){
		g.drawImage(sprite, x - camera.getX(), y - camera.getY(), null);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
