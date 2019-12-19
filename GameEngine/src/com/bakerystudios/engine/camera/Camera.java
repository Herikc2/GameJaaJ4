package com.bakerystudios.engine.camera;

public class Camera {

	private int x = 0;
	private int y = 0;
	
	public Camera(int x, int y) {
		this.setX(x);
		this.setY(y);
	}
	
	public static int clamp(int current, int min, int max) {
		if(current < min){
			current = min;
		}
		if(current > max) {
			current = max;
		}
		
		return current;
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
