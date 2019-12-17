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
		System.out.println("Points de vie du heros : "+Labyrinth.getInstance().getHeros().getLifePoint());
	}

	@Override
	public void update(Observable o, Object arg) {
		draw();
		
	}


}