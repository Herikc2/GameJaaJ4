package com.bakerystudios.gui.menu;

import java.awt.Graphics;

import com.bakerystudios.engine.Renderable;
import com.bakerystudios.engine.Updateble;
import com.bakerystudios.engine.camera.Camera;
import com.bakerystudios.game.screen.Screen;

public class PauseMenu implements Updateble, Renderable {

	private boolean option1;
	private boolean option2;
	private boolean click;

	protected static void drawCentralizedString(Graphics g, String str, int y, Screen screen) {
		g.drawString(str, screen.getSCALE_WIDTH() / 2 - g.getFontMetrics().stringWidth(str) / 2, y);
	}

	protected static void fillCentralizedRect(Graphics g, int width, int height, Screen screen) {
		g.fillRect(screen.getSCALE_WIDTH() / 2 - width / 2, screen.getSCALE_HEIGHT() / 2 - height / 2, width, height);
	}

	@Override
	public void update() {
	}

	@Override
	public void render(Graphics g) {
	}

	@Override
	public void render(Graphics g, Camera camera) {
	}

	public boolean isOption1() {
		return option1;
	}

	public void setOption1(boolean option1) {
		this.option1 = option1;
	}

	public boolean isOption2() {
		return option2;
	}

	public void setOption2(boolean option2) {
		this.option2 = option2;
	}

	public boolean isClick() {
		return click;
	}

	public void setClick(boolean click) {
		this.click = click;
	}

	@Override
	public void render(Graphics g, Screen screen) {
	}

}
