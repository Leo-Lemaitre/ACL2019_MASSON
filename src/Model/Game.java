package Model;

import java.io.IOException;
import java.util.ArrayList;
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

	private ArrayList<Monsters> monsters;
	private ArrayList<Trigger> triggers;
	private Tresor T;

	public Game(boolean gui) throws IOException {
		this.init(gui);
		if (gui) {
			this.gamePainter = new AffichageGraphiqueLabyrinthe(Labyrinthe.getInstance());
			this.gui = new GraphicalInterface(this.gamePainter, this.controller);
			Labyrinthe.getInstance().getHeros().addObserver(this.gui);

			this.gui.paint();
		} else {
			this.affichageConsole = new AffichageConsole(Labyrinthe.getInstance());
			Labyrinthe.getInstance().getHeros().addObserver(this.affichageConsole);
			this.affichageConsole.draw();
		}
	}

	public Game() throws IOException {

		// Labyrinthe.getInstance() = new Labyrinthe();
		this.controller = new Controller(Labyrinthe.getInstance().getHeros());
		this.affichageConsole = new AffichageConsole(Labyrinthe.getInstance());
		Labyrinthe.getInstance().getHeros().addObserver(this.affichageConsole);
		// this.heros.addObserver(o);
	}

	public void init(boolean gui) throws IOException {

		this.monsters = new ArrayList<Monsters>();

		this.triggers = new ArrayList<Trigger>();

		// Labyrinthe.getInstance() = new Labyrinthe();

		this.controller = new Controller(Labyrinthe.getInstance().getHeros());

	}

	public void play() throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		while (true)
			this.controller.evoluer(sc.next());
	}

	public ArrayList<Monsters> getMonsters() {
		return monsters;
	}

	public void setMonsters(ArrayList<Monsters> monsters) {
		this.monsters = monsters;
	}

	public ArrayList<Trigger> getTriggers() {
		return triggers;
	}

	public void setTriggers(ArrayList<Trigger> triggers) {
		this.triggers = triggers;
	}

	public Tresor getT() {
		return T;
	}

	public void setT(Tresor t) {
		T = t;
	}

}
