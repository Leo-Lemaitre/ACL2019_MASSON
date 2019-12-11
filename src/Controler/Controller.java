package Controler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Model.Heros;
import Model.Labyrinthe;
import Model.Monsters;
import Model.Utilitaires;

public class Controller implements KeyListener {

	private Heros modelHeros;

	public Controller(Heros model) {
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
			modelHeros.changerPosition(Utilitaires.HAUT);
			evoluer();
			break;
		case KeyEvent.VK_DOWN:
			modelHeros.changerPosition(Utilitaires.BAS);
			evoluer();
			break;
		case KeyEvent.VK_LEFT:
			modelHeros.changerPosition(Utilitaires.GAUCHE);
			evoluer();
			break;
		case KeyEvent.VK_RIGHT:
			
			modelHeros.changerPosition(Utilitaires.DROITE);
			evoluer();
			break;
		default:
			System.out.println("Touche non reconnue");
			break;
		}

	
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	public void evoluer() {
		
		
		for(Monsters m : Labyrinthe.getListeMonsters()) {
			
			m.changerPosition(Utilitaires.DIRECTIONS[(int) (Math.random()*4)]);
			
		}
	}
	
	
	public void evoluer(String c) {
		if (c.equals("Haut")) {
			this.modelHeros.changerPosition(Utilitaires.HAUT);
		}
		if (c.equals("Bas")) {
			this.modelHeros.changerPosition(Utilitaires.BAS);
		}
		if (c.equals("Gauche")) {
			this.modelHeros.changerPosition(Utilitaires.GAUCHE);
		}
		if (c.equals("Droite")) {
			this.modelHeros.changerPosition(Utilitaires.DROITE);
		}
	
	}
}
