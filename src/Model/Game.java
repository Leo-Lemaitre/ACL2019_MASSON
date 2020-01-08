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
			for (Monsters m: Labyrinth.getInstance().getListMonsters()) {
				m.addObserver(this.gui);
			}
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
		while (!jeuFini) {
			this.controller.evolve();
			Thread.sleep((int) (Math.random() * 300));
		}
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

	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	public GamePainter getGamePainter() {
		return gamePainter;
	}

	public void setGamePainter(GamePainter gamePainter) {
		this.gamePainter = gamePainter;
	}

	public AffichageConsole getAffichageConsole() {
		return affichageConsole;
	}

	public void setAffichageConsole(AffichageConsole affichageConsole) {
		this.affichageConsole = affichageConsole;
	}

	public boolean isJeuFini() {
		return jeuFini;
	}

	public void setJeuFini(boolean jeuFini) {
		this.jeuFini = jeuFini;
	}

	public GraphicalInterface getGui() {
		return gui;
	}

	public void setGui(GraphicalInterface gui) {
		this.gui = gui;
	}

}
