package Controler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Model.Game;

public class Controler implements KeyListener {

	public final static int[] HAUT = new int[] { 0, -1 };
	public final static int[] BAS = new int[] { 0, 1 };
	public final static int[] GAUCHE = new int[] { -1, 0 };
	public final static int[] DROITE = new int[] { 1, 0 };
	public final static int[][] DIRECTIONS = new int[][] { HAUT, GAUCHE, BAS, DROITE };
	private Game game;

	Controler(Game g) {
		this.game = g;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch (keyCode) {
		case KeyEvent.VK_UP:
			System.out.println("Haut");
		this.game.getHeros().changerPosition(HAUT);
			break;
		case KeyEvent.VK_DOWN:
			System.out.println("Bas");
			this.game.getHeros().changerPosition(BAS);
			break;
		case KeyEvent.VK_LEFT:
			this.game.getHeros().changerPosition(GAUCHE);
			break;
		case KeyEvent.VK_RIGHT:
			this.game.getHeros().changerPosition(DROITE);
			break;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
