package Controler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Model.Heros;
import Model.Utilitaires;
import View.GraphicalInterface;
import View.InterfaceConsole;

public class Controler implements KeyListener {

	private Heros modelHeros;

	public Controler(Heros model) {
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
			System.out.println("Haut");

			modelHeros.changerPosition(Utilitaires.HAUT);
			break;
		case KeyEvent.VK_DOWN:
			System.out.println("Bas");
			modelHeros.changerPosition(Utilitaires.BAS);

			break;
		case KeyEvent.VK_LEFT:
			System.out.println("gauche");
			modelHeros.changerPosition(Utilitaires.GAUCHE);

			break;
		case KeyEvent.VK_RIGHT:
			System.out.println("droite");
			modelHeros.changerPosition(Utilitaires.DROITE);

			break;
		default:
			System.out.println("Touche non reconnue");
			break;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
