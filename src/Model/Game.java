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
	private Heros heros;
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
			this.heros.addObserver(this.gui);

			this.gui.paint();
		} else {
			this.affichageConsole = new AffichageConsole(this.laby);
			this.heros.addObserver(this.affichageConsole);
			this.affichageConsole.draw();
		}
	}

	public Game() throws IOException {
		this.heros = new Heros();
		this.laby = new Labyrinthe();
		this.controller = new Controller(heros);
		this.affichageConsole = new AffichageConsole(this.laby);
		this.heros.mettre_sur_plateau(laby, this.heros.getPosLigne(), this.heros.getPosColonne());
		this.heros.addObserver(this.affichageConsole);
		// this.heros.addObserver(o);
	}

	public void init(boolean gui) throws IOException {
		this.heros = new Heros();
		
		this.monsters = new ArrayList<Monsters>();
		Monsters.AddMonsters(monsters);

		this.laby = new Labyrinthe();
		this.controller = new Controller(heros);

		this.heros.mettre_sur_plateau(laby, this.heros.getPosLigne(), this.heros.getPosColonne());
		
		for(Monsters m : monsters) {
			m.mettre_sur_plateau(laby, m.getPosLigne(),m.getPosColonne());
		}
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

	public Heros getHeros() {
		return heros;
	}

	public void setHeros(Heros heros) {
		this.heros = heros;
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
