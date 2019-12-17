package com.bakerystudios.game.input;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import com.bakerystudios.game.GameState;
import com.bakerystudios.gui.menu.MainMenu;
import com.bakerystudios.gui.menu.MenuState;

public class MenuInput extends Input {

	@Override
	public void keyPressed(KeyEvent e) {
		// BASIC KEYS
		// ---------------------------------------------------------------------
		if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {

		} else if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {

		}

		if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
			if (GameState.state == GameState.MENU) {
				
			}
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
			if (GameState.state == GameState.MENU) {
				
			}
		}

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (GameState.state == GameState.MENU) {
				MainMenu.enter = true;
			}
		}

		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			if (GameState.state == GameState.PLAYING) {
				GameState.state = GameState.MENU;
				MenuState.state = MenuState.PAUSE;
			} else if (GameState.state == GameState.MENU && MenuState.state == MenuState.PAUSE) {
				GameState.state = GameState.PLAYING;
			}
		}

		// OTHER KEYS
		// ---------------------------------------------------------------------

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// BASIC KEYS
		// ---------------------------------------------------------------------
		if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {

		} else if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {

		}

		if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
			if (GameState.state == GameState.MENU) {
				
			}
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
			if (GameState.state == GameState.MENU) {
				
			}
		}

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (GameState.state == GameState.MENU) {
				
			}
		}

		// OTHER KEYS
		// ---------------------------------------------------------------------

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getX() >= 470 && e.getX() <= 620 &&
				e.getY() >= 400 && e.getY() <= 440) {
			if (GameState.state == GameState.PLAYING) {
				GameState.state = GameState.MENU;
				MenuState.state = MenuState.PAUSE;
			} else if (GameState.state == GameState.MENU && MenuState.state == MenuState.PAUSE) {
				GameState.state = GameState.PLAYING;
			}
		}
		if(e.getX() >= 660 && e.getX() <= 810 &&
				e.getY() >= 400 && e.getY() <= 440) {
			if (GameState.state == GameState.MENU && MenuState.state == MenuState.PAUSE) {
				System.exit(0);
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
