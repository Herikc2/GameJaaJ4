package com.bakerystudios.gui.menu;

import java.awt.Graphics;

import com.bakerystudios.engine.Renderable;
import com.bakerystudios.engine.Updateble;
import com.bakerystudios.game.screen.Screen;

public class PauseMenu implements Updateble, Renderable {
	
	public static boolean option1;
	public static boolean option2;
	public static boolean click;

	protected static void drawCentralizedString(Graphics g, String str, int y) {
		g.drawString(str, Screen.SCALE_WIDTH / 2 - g.getFontMetrics().stringWidth(str) / 2, y);
	}
	
	protected static void fillCentralizedRect(Graphics g, int width, int height) {
		g.fillRect(Screen.SCALE_WIDTH / 2 - width / 2, Screen.SCALE_HEIGHT / 2 - height / 2, width, height);
	}
	
	@Override
	public void update() {
	}
	
	@Override
	public void render(Graphics g) {
	}
	
}
