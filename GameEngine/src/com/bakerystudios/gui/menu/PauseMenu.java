package com.bakerystudios.gui.menu;

import java.awt.Graphics;

import com.bakerystudios.engine.Renderable;
import com.bakerystudios.engine.Updateble;
import com.bakerystudios.engine.camera.Camera;
import com.bakerystudios.game.screen.Screen;

public class PauseMenu implements Updateble, Renderable {

	protected static void drawCentralizedString(Graphics g, String str, int y, Screen screen) {
		g.drawString(str, screen.SCALE_WIDTH / 2 - g.getFontMetrics().stringWidth(str) / 2, y);
	}
	
	protected static void fillCentralizedRect(Graphics g, int width, int height, Screen screen) {
		g.fillRect(screen.SCALE_WIDTH / 2 - width / 2, screen.SCALE_HEIGHT / 2 - height / 2, width, height);
	}
	
	@Override
	public void update() {
	}
	
	@Override
	public void render(Graphics g) {
	}

	@Override
	public void render(Graphics g, Camera camera) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g, Screen screen) {
		// TODO Auto-generated method stub
		
	}
	
}
