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
	private Treasure T;

	public Game(boolean gui) throws IOException {
		this.init(gui);
		if (gui) {
			this.gamePainter = new AffichageGraphiqueLabyrinthe(Labyrinth.getInstance());
			this.gui = new GraphicalInterface(this.gamePainter, this.controller);
			Labyrinth.getInstance().getHeros().addObserver(this.gui);

			this.gui.paint();
		} else {
			this.affichageConsole = new AffichageConsole(Labyrinth.getInstance());
			Labyrinth.getInstance().getHeros().addObserver(this.affichageConsole);
			this.affichageConsole.draw();
		}
	}

	public Game() throws IOException {

		// Labyrinthe.getInstance() = new Labyrinthe();
		this.controller = new Controller(Labyrinth.getInstance().getHeros());
		this.affichageConsole = new AffichageConsole(Labyrinth.getInstance());
		Labyrinth.getInstance().getHeros().addObserver(this.affichageConsole);
		// this.heros.addObserver(o);
	}

	public void init(boolean gui) throws IOException {

		this.monsters = new ArrayList<Monsters>();

		this.triggers = new ArrayList<Trigger>();

		// Labyrinthe.getInstance() = new Labyrinthe();

		this.controller = new Controller(Labyrinth.getInstance().getHeros());

	}

	public void play() throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		while (true)
			this.controller.evolve(sc.next());
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

	public Treasure getT() {
		return T;
	}

	public void setT(Treasure t) {
		T = t;
	}

}
