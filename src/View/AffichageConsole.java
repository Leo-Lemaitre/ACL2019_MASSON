package View;

import java.util.Observable;
import java.util.Observer;

import Model.Labyrinth;

public class AffichageConsole implements Observer{

	private Labyrinth lab;

	public AffichageConsole(Labyrinth labyrinthe) {
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