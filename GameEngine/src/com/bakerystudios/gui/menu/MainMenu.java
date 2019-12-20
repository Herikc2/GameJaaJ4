package com.bakerystudios.gui.menu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.bakerystudios.engine.Renderable;
import com.bakerystudios.engine.Updateble;
import com.bakerystudios.engine.camera.Camera;
import com.bakerystudios.game.screen.Screen;

public class MainMenu implements Updateble, Renderable {

	public static boolean enter; // Não sei como tirar o static
	private BufferedImage[] background;
	private int frames = 0, maxFrames = 55, index = 0, maxIndex = 1;

	public MainMenu() {
		try {
			background = new BufferedImage[2];
			background[0] = ImageIO.read(getClass().getResource("/sprites/tittle1.png"));
			background[1] = ImageIO.read(getClass().getResource("/sprites/tittle2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update() {
	}

	protected void drawCentralizedString(Graphics g, String str, int y, Screen screen) {
		g.drawString(str, Screen.SCALE_WIDTH / 2 - g.getFontMetrics().stringWidth(str) / 2, y);
	}
	
	protected void fillCentralizedRect(Graphics g, int y, int width, int height, Screen screen) {
		g.fillRect(Screen.SCALE_WIDTH / 2 - width / 2, y, width, height);
	}

	@SuppressWarnings("unused")
	private void drawButton(Graphics g, Screen screen) {
		int y = 500;
		int fontHeight = g.getFontMetrics().getHeight();
		int fontWidth = g.getFontMetrics().stringWidth("Aperte ENTER para jogar");

		int width = fontWidth + 30;
		int height = fontHeight + 20;

		g.setColor(new Color(111, 83, 39));
		fillCentralizedRect(g, y, width, height, screen);
		g.setColor(new Color(190, 163, 115));
		fillCentralizedRect(g, y + 5, width - 10, height - 10, screen);

		g.setColor(Color.BLACK);
		drawCentralizedString(g, "Aperte ENTER para jogar", y + 45, screen);
	}

	public void animation() {
		frames++;
		if (frames == maxFrames) {
			frames = 0;
			index++;
			if (index > maxIndex)
				index = 0;
		}
	}

	@Override
	public void render(Graphics g) {
		/*
		 * g.setColor(Color.BLACK); g.setFont(Game.menuFont);
		 * g.drawImage(background[index], 0, 0, null);
		 */

		// drawButton(g);
		animation();

		/*
		 * g.setColor(Color.WHITE); g.setFont(Game.boxFont); drawCentralizedString(g,
		 * "CRIADO POR: X E Y", 690);
		 */
	}

	@Override
	public void render(Graphics g, Camera camera) {
	}

	@Override
	public void render(Graphics g, Screen screen) {
		// TODO Auto-generated method stub

	}

}
