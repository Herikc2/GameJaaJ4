package com.bakerystudios.gui;

import java.awt.Graphics;

import com.bakerystudios.engine.Renderable;
import com.bakerystudios.engine.Updateble;
import com.bakerystudios.engine.camera.Camera;
import com.bakerystudios.game.GameState;
import com.bakerystudios.game.screen.Screen;
import com.bakerystudios.gui.menu.MainMenu;
import com.bakerystudios.gui.menu.MenuState;
import com.bakerystudios.gui.menu.PauseMenu;

public class UserInterface implements Renderable, Updateble {

	// private FramesPerSecond fps;
	private MainMenu mainMenu;
	private PauseMenu pauseMenu;

	public UserInterface() {
		// fps = new FramesPerSecond();
		mainMenu = new MainMenu();
		pauseMenu = new PauseMenu();
	}

	@Override
	public void update() {
		// fps.update();

		if (GameState.state == GameState.MENU) {
			if (MenuState.state == MenuState.MAIN) {
				mainMenu.update();
			}
			if (MenuState.state == MenuState.PAUSE) {
				pauseMenu.update();
			}
		}
	}

	@Override
	public void render(Graphics g) {
		// fps.render(g);

		if (GameState.state == GameState.MENU) {
			if (MenuState.state == MenuState.MAIN) {
				mainMenu.render(g);
			}
			if (MenuState.state == MenuState.PAUSE) {
				pauseMenu.render(g);
			}
		}
	}

	protected void drawCentralizedString(Graphics g, String str, int y) {
		g.drawString(str, Screen.SCALE_WIDTH / 2 - g.getFontMetrics().stringWidth(str) / 2, y);
	}

	@Override
	public void render(Graphics g, Camera camera) {
	}

	@Override
	public void render(Graphics g, Screen screen) {
		// TODO Auto-generated method stub

	}

}
