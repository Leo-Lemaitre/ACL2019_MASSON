package Model;

import java.util.ArrayList;
import java.util.Scanner;

import Controler.Controler;
import View.InterfaceConsole;

public class Game {

	private Labyrinthe Laby;
	private Heros heros;
	private ArrayList<Monsters> monsters;
	private ArrayList<Trigger> triggers;
	private Tresor T;
	private InterfaceConsole gui;
	private Controler controler;

	public final static int[] HAUT = new int[] { 0, -1 };
	public final static int[] BAS = new int[] { 0, 1 };
	public final static int[] GAUCHE = new int[] { -1, 0 };
	public final static int[] DROITE = new int[] { 1, 0 };
	public final static int[][] DIRECTIONS = new int[][] { HAUT, GAUCHE, BAS, DROITE };
	public Game() {
		this.gui=new InterfaceConsole();
		this.controler = new Controler(heros, gui);
		this.heros=new Heros();
	}

	public Labyrinthe getLaby() {
		return Laby;
	}

	public void setLaby(Labyrinthe laby) {
		Laby = laby;
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
		Scanner sc=new Scanner(System.in);
		while (true) {
			System.out.println("Position du heros : "+this.heros.getPosX()+";"+this.heros.getPosY());
		//	Commande c=controler.getCommande(); quand interface graphique
			Commande c =new Commande(sc.next());
			this.evoluer(c);
		}
	}

	private void evoluer(Commande c) {
System.out.println(c);
		if(c.getCommande().equals("Haut")) {
			this.heros.changerPosition(HAUT);
		}
		if(c.getCommande().equals("Bas")) {
			this.heros.changerPosition(BAS);
		}
		if(c.getCommande().equals("Gauche")) {
			this.heros.changerPosition(GAUCHE);
		}
		if(c.getCommande().equals("Droite")) {
			this.heros.changerPosition(DROITE);
		}
		
	}

}
