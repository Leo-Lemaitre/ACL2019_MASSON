package Model;

import java.io.IOException;
import java.util.Scanner;

import Controler.Controller;
import View.AffichageConsole;
import View.AffichageGraphiqueLabyrinthe;
import View.GamePainter;
import View.GraphicalInterface;

public class Game {

	private GraphicalInterface gui;
	private Controller controller;
	private GamePainter gamePainter;
	private AffichageConsole affichageConsole;
	private boolean jeuFini;

	public Game(boolean gui) throws IOException {
		this.init(gui);
		if (gui) {
			this.gamePainter = new AffichageGraphiqueLabyrinthe();
			this.gui = new GraphicalInterface(this.gamePainter, this.controller);
			Labyrinth.getInstance().getHeros().addObserver(this.gui);
			this.gui.paint();
		} else {
			this.affichageConsole = new AffichageConsole(Labyrinth.getInstance());
			Labyrinth.getInstance().getHeros().addObserver(this.affichageConsole);
			this.affichageConsole.draw();
		}
		
	}

	public void init(boolean gui) throws IOException {
		Labyrinth.getInstance();
		this.controller = new Controller(Labyrinth.getInstance().getHeros(), this);
		this.jeuFini = false;

	}

	public void play() throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		while (!jeuFini)
			this.controller.evolve(sc.next());
	}

	public boolean isEndGame() {
		if (Labyrinth.getInstance().getHeros().isDead() || Labyrinth.getInstance().getTreasure().isTreasureOwned()) {
			endGame();
			return true;
		}
		return false;

	}

	public void endGame() {
		System.out.println("Jeu fini");
		jeuFini = true;
		if (this.gui != null) {
			this.gui.getPanel().removeKeyListener(this.controller);
		}
	}

}
