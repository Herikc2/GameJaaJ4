package com.bakerystudios.engine;

import java.awt.Graphics;

import com.bakerystudios.engine.camera.Camera;
import com.bakerystudios.game.screen.Screen;

public interface Renderable {
	
	public void render(Graphics g);

	public void render(Graphics g, Camera camera);

	void render(Graphics g, Screen screen);
	
}
