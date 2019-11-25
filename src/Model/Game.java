package Model;

import java.util.ArrayList;

import View.InterfaceGraphique;


public class Game {

	private Labyrinthe Laby;
	private Heros heros;
	private ArrayList<Monsters> monsters;
	private ArrayList<Trigger> triggers;
	private Tresor T;
	private InterfaceGraphique gui;

	public Game() {
		
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

	public InterfaceGraphique getGui() {
		return gui;
	}

	public void setGui(InterfaceGraphique gui) {
		this.gui = gui;
	}

	public void play() {
		while(true) {
			
		}
	};

}
