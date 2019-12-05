package Model;

import java.util.Observable;

public abstract class Character extends Observable {
	protected int posLigne;
	protected int posColonne;
	protected int lifePoint;
	protected char type;

	public void changerPosition(int[] direction) {
		if (deplacementPossible(direction)) {
			Labyrinthe.setTypeOfCase(this.getPosLigne(), this.getPosColonne(), Utilitaires.VIDE);
			this.setPosLigne(this.getPosLigne() + direction[0]);
			this.setPosColonne(this.getPosColonne() + direction[1]);
			Labyrinthe.setTypeOfCase(this.getPosLigne(), this.getPosColonne(), type);
			 setChanged();
		     notifyObservers();
		} else {
			System.out.println("Deplacement impossible");
		}
	}

	public abstract boolean deplacementPossible(int[] direction);

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

	public int getLifePoint() {
		return lifePoint;
	}

	public void setLifePoint(int lifePoint) {
		this.lifePoint = lifePoint;
	}

}
