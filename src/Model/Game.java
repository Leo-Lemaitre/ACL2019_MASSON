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

	private Labyrinthe laby;
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
			this.gamePainter = new AffichageGraphiqueLabyrinthe(this.laby);
			this.gui = new GraphicalInterface(this.gamePainter, this.controller);
			this.laby.getHeros().addObserver(this.gui);

			this.gui.paint();
		} else {
			this.affichageConsole = new AffichageConsole(this.laby);
			this.laby.getHeros().addObserver(this.affichageConsole);
			this.affichageConsole.draw();
		}
	}

	public Game() throws IOException {

		this.laby = new Labyrinthe();
		this.controller = new Controller(laby.getHeros());
		this.affichageConsole = new AffichageConsole(this.laby);
		this.laby.getHeros().addObserver(this.affichageConsole);
		// this.heros.addObserver(o);
	}

	public void init(boolean gui) throws IOException {

		this.monsters = new ArrayList<Monsters>();

		this.triggers = new ArrayList<Trigger>();

		this.laby = new Labyrinthe();

		this.controller = new Controller(laby.getHeros());

	}

	public void play() throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		while (true)
			this.controller.evoluer(sc.next());
	}

	public Labyrinthe getLaby() {
		return laby;
	}

	public void setLaby(Labyrinthe laby) {
		laby = laby;
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
