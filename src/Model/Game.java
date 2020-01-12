package Model;

import java.io.IOException;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

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
	private char difficulty;

	public Game(boolean gui, char difficulty) throws IOException {
		this.init(gui,difficulty);
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

	public void init(boolean gui,char difficulty) throws IOException {
		Labyrinth.getInstance();
		this.controller = new Controller(Labyrinth.getInstance().getHeros(), this);
		this.jeuFini = false;
		this.difficulty=difficulty;

	}

	public void play() throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		Timer t = new Timer();
		final Controller a = this.controller;
		final Hero h = Labyrinth.getInstance().getHeros();
		long startTime = 0;
		Timer timer = new Timer();
		TimerTask tache1 = new TimerTask() {
			@Override
			public void run() {
				h.update();
				if(jeuFini){
					this.cancel();
				}

			}
		};
		TimerTask tache2 = new TimerTask() {
			@Override
			public void run() {
				a.evolve();
				if(jeuFini){
					this.cancel();
				}

			}
		};
		timer.schedule(tache1, startTime, 10);
		switch(difficulty){
		case 'e':
			timer.schedule(tache2, startTime, Constants.SPEEDMONSTERSEASY);
			break;
		case 'i':
			timer.schedule(tache2, startTime, Constants.SPEEDMONSTERSINTERMEDIATE);
			break;
		case 'h':
			timer.schedule(tache2, startTime, Constants.SPEEDMONSTERSHARD);
			break;
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
