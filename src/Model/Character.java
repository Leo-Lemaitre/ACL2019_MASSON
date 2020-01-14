package Model;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Observable;

/**
 * Classe abstraite Character qui herite de la classe ElementLab qui contient
 * tous les etres vivants du labyrinthe
 */

public abstract class Character extends ElementLab {

	/**
	 * attribut protege lifePoint les points de vie du character
	 */
	protected int lifePoint;
	/**
	 * attribut protege indique la direction vers laquelle est oriente le
	 * personnage
	 */
	protected int[] direction;

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
		this.lifePoint = lifepoint;
		this.direction = Constants.DOWN;

	}

	/**
	 * Methode permettant de changer la position du character dans une direction
	 * si ce changement est possible
	 * 
	 * @param direction
	 */

	public void changePosition(int[] direction) {
		if (deplacementPossible(direction)) {
			Labyrinth.getInstance().setElementOnSquare(this.getPosLigne(), this.getPosColonne(),
					new Empty(this.getPosLigne(), this.getPosColonne()));
			this.setPosLigne(this.getPosLigne() + direction[0]);
			this.setPosColonne(this.getPosColonne() + direction[1]);
			this.direction = direction;
			Labyrinth.getInstance().setElementOnSquare(this.getPosLigne(), this.getPosColonne(), this);
			// update();
		} else {
			System.out.println("Deplacement impossible");
		}

	}

	public int[] getDirection() {
		return direction;
	}

	public void setDirection(int[] direction) {
		this.direction = direction;
	}

	/**
	 * Methode abstraite permettant de verifier si le deplacement est possible
	 * 
	 * @param direction
	 * @return boolean
	 */

	public abstract boolean deplacementPossible(int[] direction);

	public boolean isDead() {
		return this.lifePoint <= 0;
	}

	public int getLifePoint() {
		return lifePoint;
	}

	public void setLifePoint(int lifePoint) {
		this.lifePoint = lifePoint;
		// update();
	}

	public void addLifePoint(int lifePoint) {
		this.lifePoint += lifePoint;
		// update();
	}

	public void loseLifePoint(int lifePoint) {
		this.lifePoint -= lifePoint;
		if (this.lifePoint < 0)
			this.lifePoint = 0;
		// update();
	}

	/**
	 * Methode abstraiteaux element de type Character d attaquer
	 */
	public abstract void attack();

	public void dieM() {
		Labyrinth.getListMonsters().remove(this);
		Labyrinth.getInstance().setElementOnSquare(this.posLigne, this.posColonne,
				new Empty(this.posLigne, this.posColonne));
	}

}
