package Model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Controler.Controler;
import View.AffichageLabyrinthe;
import View.GamePainter;
import View.GraphicalInterface;

public class Game {

	private Labyrinthe laby;
	private Heros heros;
	private ArrayList<Monsters> monsters;
	private ArrayList<Trigger> triggers;
	private Tresor T;
	private GraphicalInterface gui;
	private Controler controler;
	private AffichageLabyrinthe affichelab;
	private GamePainter gamePainter;

	public Game() throws IOException {
		this.heros = new Heros();

		this.laby = new Labyrinthe();
		this.controler = new Controler(heros);
		this.gamePainter = new AffichageLabyrinthe(this.laby);
		this.gui = new GraphicalInterface(this.gamePainter, this.controler);
		this.heros.mettre_Heros_sur_plateau(laby, this.heros.getPosLigne(), this.heros.getPosColonne());
		this.heros.addObserver(this.gui);
		// this.heros.addObserver(o);

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

	public void play() throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		this.gui.paint();
		while (true)
			this.evoluer(sc.next());
	}

	private void evoluer(String c) {
		System.out.println(c);
		if (c.equals("Haut")) {
			this.heros.changerPosition(Utilitaires.HAUT);
		}
		if (c.equals("Bas")) {
			this.heros.changerPosition(Utilitaires.BAS);
		}
		if (c.equals("Gauche")) {
			this.heros.changerPosition(Utilitaires.GAUCHE);
		}
		if (c.equals("Droite")) {
			this.heros.changerPosition(Utilitaires.DROITE);
		}

	}

}
