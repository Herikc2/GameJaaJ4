package com.bakerystudios.game.screen;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.JFrame;

import com.bakerystudios.game.input.Input;

public class Screen extends Canvas {

	/**
	 * Default serialVersionUID
	 */
	private static final long serialVersionUID = -8027725672170867390L;
	
	private int SCALE = 5;
	private int WIDTH = 1280 / SCALE;
	private int HEIGHT = (getWIDTH() / 16) * 9;
	private int SCALE_WIDTH = getWIDTH() * SCALE;
	private int SCALE_HEIGHT = getHEIGHT() * SCALE;	

	private JFrame frame;
	
	public Screen(List<Input> inputs) {
		for(Input input : inputs) {
			addKeyListener(input);
			addMouseListener(input);
		}
		//initScreenSize();
		setPreferredSize(new Dimension(getSCALE_WIDTH(), getSCALE_HEIGHT()));
		frame = new JFrame("Generic Name Game");
		frame.add(this);
		frame.setResizable(false);
		//frame.setResizable(true);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
		//frame.setResizable(false);
	}

	// pega a resolução do monitor para inicializar
	// a resolução do jogo
	@SuppressWarnings("unused")
	private void initScreenSize() {
		Toolkit tk = Toolkit.getDefaultToolkit();
	    Dimension d = tk.getScreenSize();
		WIDTH = d.width / SCALE;
		HEIGHT = d.height / SCALE;
		SCALE_WIDTH = getWIDTH() * SCALE;
		SCALE_HEIGHT = getHEIGHT() * SCALE;
	}

	public int getWIDTH() {
		return WIDTH;
	}

	public int getHEIGHT() {
		return HEIGHT;
	}

	public int getSCALE_WIDTH() {
		return SCALE_WIDTH;
	}

	public int getSCALE_HEIGHT() {
		return SCALE_HEIGHT;
	}
	
}
