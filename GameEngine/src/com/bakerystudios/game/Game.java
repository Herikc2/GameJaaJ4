package com.bakerystudios.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.bakerystudios.engine.Renderable;
import com.bakerystudios.engine.Updateble;
import com.bakerystudios.engine.camera.Camera;
import com.bakerystudios.engine.graphics.engine.Spritesheet;
import com.bakerystudios.engine.graphics.engine.Tile;
import com.bakerystudios.engine.graphics.engine.World;
import com.bakerystudios.entities.Entity;
import com.bakerystudios.entities.Player;
import com.bakerystudios.game.input.DebugInput;
import com.bakerystudios.game.input.Input;
import com.bakerystudios.game.input.MenuInput;
import com.bakerystudios.game.input.PlayerInput;
import com.bakerystudios.game.screen.Screen;
import com.bakerystudios.gui.GraphicUserInterface;
import com.bakerystudios.sound.AudioManager;

public class Game implements Runnable, Renderable, Updateble {

	private final int MAP = 0;
	private int CUR_MAP = MAP;
	
	private boolean isRunning;

	private Thread thread;
	private Screen screen;
	private List<Input> inputs = new ArrayList<>();
	
	private Font boxFont;
	private Font menuFont;
	private Font inventFont;
	private InputStream boxFontStream = ClassLoader.getSystemClassLoader().getResourceAsStream("font.ttf");
	private InputStream menuFontStream = ClassLoader.getSystemClassLoader().getResourceAsStream("font.ttf");
	private InputStream inventFontStream = ClassLoader.getSystemClassLoader().getResourceAsStream("font.ttf");

	private Random rand;

	private BufferedImage frame;
	private GraphicUserInterface gui;

	private AudioManager audio;

	private Player player;

	public static Spritesheet spritesheet; // Não sei como retirar o static
	private Spritesheet characters;
	private List<World> world;
	private List<Entity> entities;

	public static boolean enter; // Não sei retirar o static
	public static boolean gameEvent = false; // Não sei retirar o static
	
	private boolean EXIT = false;

	public Game() {
		// Object instantiation
		
		// carregamento dos inputs
		inputs = new ArrayList<>();
		inputs.add(new MenuInput());
		inputs.add(new PlayerInput());
		inputs.add(new DebugInput());
		screen = new Screen(inputs);
		
		// carregamento das fontes
		loadFonts();
		
		// outros carregamentos
		setRand(new Random());
		frame = new BufferedImage(screen.WIDTH, screen.HEIGHT, BufferedImage.TYPE_INT_RGB);
		
		gui = new GraphicUserInterface();
		audio = new AudioManager();
		
		// carregamento das sprites
		spritesheet = new Spritesheet("/sprites/spritesheet.png");
		characters = new Spritesheet("/sprites/characters.png");
		
		player = new Player(0, 0, Tile.SIZE, Tile.SIZE, null, characters);
		entities = new ArrayList<Entity>();

		// carregamento dos mapas
		world = new ArrayList<>();
		//world.add(new World("/levels/map.png", "/levels/map_collision.png", player));
		
		// carregamento das entidades
		entities.add(player);
	}
	
	public void loadFonts() {
		try {
			setBoxFont(Font.createFont(Font.TRUETYPE_FONT, boxFontStream).deriveFont(Font.PLAIN, 20));
			setMenuFont(Font.createFont(Font.TRUETYPE_FONT, menuFontStream).deriveFont(Font.PLAIN, 40));
			setInventFont(Font.createFont(Font.TRUETYPE_FONT, inventFontStream).deriveFont(Font.PLAIN, 15));
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
	}

	public synchronized void start() {
		thread = new Thread(this);
		isRunning = true;
		thread.start();
	}

	public synchronized void stop() {
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update() {
		gui.update();
		audio.update();
		
		if (GameState.state == GameState.PLAYING) {
			for (Entity e : entities) {
				if(e instanceof Player)
					((Player) e).update(world, screen, CUR_MAP);
				else
					e.update();
			}
		} 
		
		if(EXIT)
			System.exit(0);
	}

	private void nonPixelatedRender(Graphics g) {
		gui.render(g);
		
//		g.setColor(Color.RED);
//		g.setFont(new Font("arial", Font.PLAIN, 15));
//		g.drawString("x: " + player.getX() + " y: " + player.getY(), 1100, 23);
	}

	private void pixelatedRender(Graphics g) {
		//world.get(CUR_MAP).render(g);
		for (Entity e : entities)
			e.render(g);
	}

	@Override
	public void render(Graphics g) {
		BufferStrategy bs = screen.getBufferStrategy();
		if (bs == null) {
			screen.createBufferStrategy(3);
			return;
		}

		g = frame.getGraphics();

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, screen.WIDTH, screen.HEIGHT);

		pixelatedRender(g);

		g.dispose();
		g = bs.getDrawGraphics();
		g.drawImage(frame, 0, 0, Screen.SCALE_WIDTH, Screen.SCALE_HEIGHT, null);
		
		nonPixelatedRender(g);
		
		bs.show();
	}

	@Override
	public void run() {
		double amountOfTicks = 60.0;
		double ns = 1000000000.0 / amountOfTicks;
		double delta = 0;
		long lastTime = System.nanoTime();

		screen.requestFocus(); 
		while (isRunning) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;

			if (delta >= 1) {
				update();
				render(null);
				delta--;
			}
		}

		stop();
	}

	public Spritesheet getSpritesheet() {
		return spritesheet;
	}

	public void setSpritesheet(Spritesheet spritesheet) {
		Game.spritesheet = spritesheet;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Font getBoxFont() {
		return boxFont;
	}

	public void setBoxFont(Font boxFont) {
		this.boxFont = boxFont;
	}

	public Font getMenuFont() {
		return menuFont;
	}

	public void setMenuFont(Font menuFont) {
		this.menuFont = menuFont;
	}

	public Font getInventFont() {
		return inventFont;
	}

	public void setInventFont(Font inventFont) {
		this.inventFont = inventFont;
	}

	public Random getRand() {
		return rand;
	}

	public void setRand(Random rand) {
		this.rand = rand;
	}

	@Override
	public void render(Graphics g, Camera camera) {
	}

}
