package Model;

import java.util.Observable;

public abstract class ElementLab extends Observable {

	protected int posLigne;
	protected int posColonne;
	protected char type;
	protected Labyrinthe lab;
	
	public ElementLab(int posLigne, int posColonne, Labyrinthe lab) {
		this.posLigne = posLigne;
		this.posColonne = posColonne;
		this.lab = lab;
	}
	
	/*public ElementLab() {
		this.posLigne = 5;
		this.posColonne = 5;
	}
	*/
	
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
