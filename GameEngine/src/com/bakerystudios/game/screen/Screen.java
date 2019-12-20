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
	
	public int SCALE = 5;
	public int WIDTH = 1280 / SCALE;
	public int HEIGHT = ((1280 / 5) / 16) * 9;
	public int SCALE_WIDTH = (1280 / 5) * 5;
	public int SCALE_HEIGHT = (((1280 / 5) / 16) * 9) * 5;
	
	/*
	public int SCALE = 5;
	public int WIDTH = 1280 / SCALE;
	public static int HEIGHT = (WIDTH / 16) * 9; // (WIDTH / 16) * 9
	public static int SCALE_WIDTH = WIDTH * SCALE; // WIDTH * SCALE
	public static int SCALE_HEIGHT = HEIGHT * SCALE; // HEIGHT * SCALE
	*/

	private JFrame frame;
	
	public Screen(List<Input> inputs) {
		for(Input input : inputs) {
			addKeyListener(input);
			addMouseListener(input);
		}
		//initScreenSize();
		setPreferredSize(new Dimension(SCALE_WIDTH, SCALE_HEIGHT));
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
		SCALE_WIDTH = WIDTH * SCALE;
		SCALE_HEIGHT = HEIGHT * SCALE;
	}
	
}
