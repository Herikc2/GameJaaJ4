package com.bakerystudios.gui;

import java.awt.Graphics;

import com.bakerystudios.engine.Renderable;
import com.bakerystudios.engine.Updateble;
import com.bakerystudios.engine.camera.Camera;
import com.bakerystudios.game.screen.Screen;

public class GraphicUserInterface implements Renderable, Updateble {

	private UserInterface ui;
	private HeadUpDisplay hud;
	
	public GraphicUserInterface() {
		ui = new UserInterface(); 
		hud = new HeadUpDisplay();
	}
	
	@Override
	public void update() {
		ui.update();
		hud.update();
	}

	@Override
	public void render(Graphics g) {
		ui.render(g);
		hud.render(g);
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
