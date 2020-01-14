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

/**
 * Classe Controller qui herite de la classe KeyListener qui gere
 * l evolution du heros dans le jeu
 */

public class Controller implements KeyListener {
	
	/**
	 * attribut protege modelHeros qui correspond au heros
	 */
	
	private Hero modelHeros;
	
	/**
	 * attribut protege game qui contient le jeu
	 */
	
	private Game game;

	/**
	 * Constructeur qui initialise un Controller 
	 * @param model
	 * @param g
	 */
	public Controller(Hero model, Game g) {
		this.modelHeros = model;
		this.game = g;
	}
	/**
	 * Methode utilisee lorsqu une touche a ete tapee 
	 * 
	 * @param e
	 */

	@Override
	public void keyTyped(KeyEvent e) {
	}

	
	/**
	 * Methode utilisee lorsqu une touche est enfoncee 
	 * Elle recupere la touche enfoncee et change la 
	 * position du heros en fonction de celle ci
	 * Elle appelle la methode attack si 
	 * le joueur appuie sur la barre espace
	 * @param e
	 */
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
	
	/**
	 * Methode utilisee lorsqu une touche a ete relachee 
	 * 
	 * @param e
	 */

	@Override
	public void keyReleased(KeyEvent e) {
	}

	/**
	 * Methode evolve permettant aux monstres d aller attaquer le 
	 * heros si ils sont a une distance euclidienne de 1  
	 * 
	 */

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

	/**
	 * Methode evolve permettant de changer
	 * la position du heros  
	 * 
	 * @param c
	 */
	
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
