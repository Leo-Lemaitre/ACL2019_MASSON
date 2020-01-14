package Model;

import java.io.IOException;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import Controller.Controller;
import View.AffichageConsole;
import View.AffichageGraphiqueLabyrinthe;
import View.GamePainter;
import View.GraphicalInterface;

/**
 * Classe Game qui instancie le jeu
 *
 */
public class Game {
	/**
	 * Attribut de type GraphicalInterface permettant l affichage du labyrinthe
	 */
	private GraphicalInterface gui;
	/**
	 * Attribut de type Controller permettant au joueur de controler le heros
	 */
	private Controller controller;
	/**
	 * Attribut de type GamePainter permettant de dessiner dans l interface graphique
	 */
	private GamePainter gamePainter;
	/**
	 * Attribut de type booleen qui indique si le jeu est termine ou on
	 */
	private boolean jeuFini;
	/**
	 * Attribut de type char qui indique la difficulte du jeu
	 */
	private char difficulty;
/**
 * Constructeur de la classe Game
 * @param gui affiche les sprites si vaut vrai
 * @param difficulty difficulte du jeu
 * @throws IOException
 */
	public Game(boolean gui, char difficulty) throws IOException {
		this.init(gui, difficulty);
		if (gui) {
			this.gamePainter = new AffichageGraphiqueLabyrinthe();
			this.gui = new GraphicalInterface(this.gamePainter, this.controller);
			Labyrinth.getInstance().getHeros().addObserver(this.gui);

			this.gui.paint();
		} else {
			AffichageConsole affichageConsole = new AffichageConsole(Labyrinth.getInstance());
			Labyrinth.getInstance().getHeros().addObserver(affichageConsole);
			affichageConsole.draw();
		}

	}
	/**
	 * Methode qui initialise les attributs communs du constructeur
	 * @param gui affiche les sprites si vaut vrai
	 * @param difficulty difficulte du jeu
	 * @throws IOException
	 */
	public void init(boolean gui, char difficulty) throws IOException {
		Labyrinth.getInstance();
		this.jeuFini = false;
		this.difficulty = difficulty;
		this.controller = new Controller(Labyrinth.getInstance().getHeros(), this);

	}
/**
 * Methode permettant le deroulement du jeu tant que celui ci n est pas termine
 * @throws InterruptedException
 */
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
				if (jeuFini) {
					this.cancel();
				}

			}
		};
		TimerTask tache2 = new TimerTask() {
			@Override
			public void run() {
				a.evolve();
				if (jeuFini) {
					this.cancel();
				}

			}
		};
		try {

			timer.schedule(tache1, startTime, 10);
			switch (difficulty) {
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
		} catch (Exception e) {
		}
		;

	}
/**
 * Methode indiquant si le jeu est termine ou non
 * @return true si le tresor est recupere ou le heros est mort
 */
	public boolean isEndGame() {
		if (Labyrinth.getInstance().getHeros().isDead() || Labyrinth.getInstance().getTreasure().isTreasureOwned()) {
			endGame();
			return true;
		}
		return false;

	}
/**
 * Methode qui met un terme au jeu
 */
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
