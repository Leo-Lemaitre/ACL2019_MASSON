package Model;

import java.util.Observable;

/**
 * Classe abstraite ElementLab qui herite de la classe Observable qui contient
 * tous les elements qui interagissent sur le labyrinthe 
 */

public abstract class ElementLab extends Observable {

	//
	/**
	 * attributs proteges de position et de type des elements 
	 */
	protected int posLigne;
	protected int posColonne;
	protected char type;
	
	
	/**
	 * Constructeur qui initialise un element a une position donnee posLigne posLigne 
	 * @param posLigne 
	 * @param posColonne
	 * @param lifepoint
	 */
	public ElementLab(int posLigne, int posColonne) {
		this.posLigne = posLigne;
		this.posColonne = posColonne;
	}
	
	public int getPosLigne() {
		return posLigne;
	}

	public void setPosLigne(int posLigne) {
		this.posLigne = posLigne;
	}

	public int getPosColonne() {
		return posColonne;
	}

	public void setPosColonne(int posColonne) {
		this.posColonne = posColonne;
	}
	
	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	public void update() {
		setChanged();
		notifyObservers();
	}

	@Override
	public String toString() {
		return ""+ type +"";
	}
	
	
}
