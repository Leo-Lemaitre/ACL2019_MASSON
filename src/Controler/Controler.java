package Controler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import Model.Heros;
import View.InterfaceConsole;

public class Controler implements KeyListener {

	private Heros modelHeros;
	private InterfaceConsole view;


	public Controler(Heros model, InterfaceConsole view) {
		this.modelHeros = model;
		this.view = view;
		
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

		//	this.c = new Commande("Haut");
			//this.c = new Commande("Haut");
			break;
		case KeyEvent.VK_DOWN:
			System.out.println("Bas");

			break;
		case KeyEvent.VK_LEFT:

			break;
		case KeyEvent.VK_RIGHT:

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
/*
	public Commande getCommande() {
		return this.c;
	}
*/
}
