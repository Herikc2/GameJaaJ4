package com.bakerystudios.engine;

import java.awt.Graphics;

import com.bakerystudios.engine.camera.Camera;

public interface Renderable {
	
	public void render(Graphics g);

	void render(Graphics g, Camera camera);
	
}
