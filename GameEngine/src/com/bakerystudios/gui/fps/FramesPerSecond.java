package com.bakerystudios.gui.fps;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.bakerystudios.engine.Renderable;
import com.bakerystudios.engine.Updateble;
import com.bakerystudios.engine.camera.Camera;
import com.bakerystudios.game.screen.Screen;

public class FramesPerSecond implements Renderable, Updateble {

	private String FPS = "FPS: 00";
	private int frames = 0;
	private double timer;

	public FramesPerSecond() {
		timer = System.currentTimeMillis();
	}

	@Override
	public void update() {
		frames++;
		if (System.currentTimeMillis() - timer >= 1000) {
			FPS = "FPS: " + Integer.toString(frames);
			frames = 0;
			timer += 1000;
		}
	}

	@Override
	public void render(Graphics g, Screen screen) {
		g.setColor(Color.YELLOW);
		g.setFont(new Font("Arial", Font.PLAIN, (int) (screen.getSCALE_WIDTH() * 0.012)));
		g.drawString(FPS, screen.getSCALE_WIDTH() - (int) (screen.getSCALE_WIDTH() * 0.050),
				(int) (screen.getSCALE_WIDTH() * 0.018));
	}

	@Override
	public void render(Graphics g, Camera camera) {
	}

	@Override
	public void render(Graphics g) {
	}

}
