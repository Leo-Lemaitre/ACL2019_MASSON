package View;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import Model.Labyrinthe;
import Model.Utilitaires;

public class AffichageConsole implements Observer{

	private Labyrinthe lab;

	public AffichageConsole(Labyrinthe labyrinthe) {
		this.lab = labyrinthe;
	}

	public void draw() {
		System.out.println(lab);
	}

	@Override
	public void update(Observable o, Object arg) {
		draw();
		
	}


}