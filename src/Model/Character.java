package Model;

import java.io.IOException;
import java.util.Observable;

/**
 * Classe abstraite Character qui herite de la classe ElementLab qui contient
 * tous les etres vivants du labyrinthe
 */

public abstract class Character extends ElementLab {

	//
	/**
	 * attribut protege lifePoint les points de vie du character
	 */
	protected int lifePoint;

	/**
	 * Constructeur qui initialise un character a une position donnee posLigne
	 * posLigne et en lui donnant des points de vie
	 * 
	 * @param posLigne
	 * @param posColonne
	 * @param lifepoint
	 */

	public Character(int posLigne, int posColonne, int lifepoint) {
		super(posLigne, posColonne);
		this.lifePoint = 10;
	}

	/**
	 * Methode permettant de changer la position du character dans une direction si
	 * ce changement est possible
	 * 
	 * @param direction
	 */

	public void changePosition(int[] direction) {
		if (deplacementPossible(direction)) {
			Labyrinth.getInstance().setElementOnSquare(this.getPosLigne(), this.getPosColonne(),
					new Empty(this.getPosLigne(), this.getPosColonne()));
			this.setPosLigne(this.getPosLigne() + direction[0]);
			this.setPosColonne(this.getPosColonne() + direction[1]);
			Labyrinth.getInstance().setElementOnSquare(this.getPosLigne(), this.getPosColonne(), this);

		} else {
			// System.out.println("Deplacement impossible");
		}
		update();
	}

	/**
	 * Methode abstraite permettant de verifier si le deplacement est possible
	 * 
	 * @param direction
	 * @return boolean
	 */

	public abstract boolean deplacementPossible(int[] direction);
	
	public boolean isDead() {
		return this.lifePoint<=0;
	}

	public int getLifePoint() {
		return lifePoint;
	}

	public void setLifePoint(int lifePoint) {
		this.lifePoint = lifePoint;
		update();
	}

	public void addLifePoint(int lifePoint) {
		this.lifePoint += lifePoint;
		update();
	}

	public void loseLifePoint(int lifePoint) {
		this.lifePoint -= lifePoint;
		update();
	}

}
