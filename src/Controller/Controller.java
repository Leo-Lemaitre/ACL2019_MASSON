package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.TimerTask;

import Model.Constants;
import Model.Game;
import Model.Hero;
import Model.Labyrinth;
import Model.Monsters;

public class Controller implements KeyListener {

	private Hero modelHeros;
	private Game game;

	public Controller(Hero model, Game g) {
		this.modelHeros = model;
		this.game = g;
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
			break;
		case KeyEvent.VK_DOWN:
			modelHeros.changePosition(Constants.DOWN);
			break;
		case KeyEvent.VK_LEFT:
			modelHeros.changePosition(Constants.LEFT);
			break;
		case KeyEvent.VK_RIGHT:
			modelHeros.changePosition(Constants.RIGHT);
			break;
		case KeyEvent.VK_SPACE:
			modelHeros.attack();

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
		if (!game.isEndGame()) {
			for (Monsters m : Labyrinth.getListMonsters()) {
				if (m.distanceWithElement(Labyrinth.getInstance().getHeros()) == 1) {
					m.attack();
				}

				else {
					if (Math.random() > 0.3) {
						m.changePosition(m.getDirectionCloserToTheHero());

					}
				}
				System.out.println("Life point " + m.getLifePoint());

			}

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
