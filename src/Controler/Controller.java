package Controler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Model.Hero;
import Model.Labyrinth;
import Model.Monsters;
import Model.Constants;

public class Controller implements KeyListener {

	private Hero modelHeros;

	public Controller(Hero model) {
		this.modelHeros = model;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();

		switch (keyCode) {

		case KeyEvent.VK_UP:
			modelHeros.changePosition(Constants.UP);
			evolve();
			break;
		case KeyEvent.VK_DOWN:
			modelHeros.changePosition(Constants.DOWN);
			evolve();
			break;
		case KeyEvent.VK_LEFT:
			modelHeros.changePosition(Constants.LEFT);
			evolve();
			break;
		case KeyEvent.VK_RIGHT:

			modelHeros.changePosition(Constants.RIGHT);
			evolve();
			break;
		case KeyEvent.VK_SPACE:
			modelHeros.attack();
			evolve();
			break;
		default:
			System.out.println("Touche non reconnue");
			break;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	public void evolve() {
		for (Monsters m : Labyrinth.getListMonsters()) {
			m.changePosition(Constants.DIRECTIONS[(int) (Math.random() * 4)]);
			System.out.println("Life point " + m.getLifePoint());
		}
		
	}

	public void evolve(String c) {
		if (c.equals("Haut")) {
			this.modelHeros.changePosition(Constants.UP);
		}
		if (c.equals("Bas")) {
			this.modelHeros.changePosition(Constants.DOWN);
		}
		if (c.equals("Gauche")) {
			this.modelHeros.changePosition(Constants.LEFT);
		}
		if (c.equals("Droite")) {
			this.modelHeros.changePosition(Constants.RIGHT);
		}

	}
}
