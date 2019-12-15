package Model;

import java.util.Observable;

public abstract class ElementLab extends Observable {

	protected int posLigne;
	protected int posColonne;
	protected char type;
	
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
