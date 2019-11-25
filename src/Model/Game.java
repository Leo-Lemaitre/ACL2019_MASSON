package Model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Controler.Controler;
import View.InterfaceConsole;

public class Game {

	private Labyrinthe laby;
	private Heros heros;
	private ArrayList<Monsters> monsters;
	private ArrayList<Trigger> triggers;
	private Tresor T;
	private InterfaceConsole gui;
	private Controler controler;

	public Game() throws IOException {
		this.gui = new InterfaceConsole();
		this.controler = new Controler(heros, gui);
		this.heros = new Heros();
		this.laby=new Labyrinthe();
		this.heros.mettre_Heros_sur_plateau(laby, this.heros.getPosX(), this.heros.getPosY());
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

	public void play() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			 System.out.println(laby);
			System.out.println("Position du heros : " + this.heros.getPosX() + ";" + this.heros.getPosY());
			// Commande c=controler.getCommande(); quand interface graphique
			// Commande c =new Commande(sc.next());
			String c = sc.next();
			this.evoluer(c);
		}
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
