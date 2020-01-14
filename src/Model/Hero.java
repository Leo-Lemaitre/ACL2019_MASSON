package Model;

import java.util.Observable;
import java.util.Observer;

/**
 * Classe Hero qui herite de la classe Character qui s occupe du deplacement du
 * joueur
 */

public class Hero extends Character {

	/**
	 * Constructeur qui initialise un heros a une position donnee posLigne
	 * posLigne et en lui donnant des points de vie en reutilisant le
	 * superconstructeur de la classe Character en precisant le type hero
	 * 
	 * @param posLigne
	 * @param posColonne
	 * @param lifepoint
	 */

	public Hero(int posLigne, int posColonne, int lifepoint) {
		super(posLigne, posColonne, lifepoint);
		this.type = Constants.HERO;
		this.imageName = "Character";
	}

	/**
	 * Methode permettant de verifier si le deplacement est possible en s
	 * assurant que la case est vide ou piegee
	 * 
	 * @param direction
	 * @return boolean
	 */
	@Override
	public boolean deplacementPossible(int[] direction) {
		ElementLab element = Labyrinth.getInstance().getElementOnSquare(this.getPosLigne() + direction[0],
				this.getPosColonne() + direction[1]);
		if (element == null) {
			return false;
		}
		if (element.getType() == Constants.EMPTY) {
			return true;

		}
		if (element.getType() == Constants.TRAP || element.getType() == Constants.HEALER
				|| element.getType() == Constants.TREASURE) {
			((Trigger) Labyrinth.getInstance().getElementOnSquare(this.getPosLigne() + direction[0],
					this.getPosColonne() + direction[1])).effect();
			return true;

		}
		return false;
	}

	public void attack() {
		for (int[] direction : Constants.DIRECTIONS) {
			if (Labyrinth.getInstance().getElementOnSquare(this.posLigne + direction[0], this.posColonne + direction[1])
					.getType() == Constants.MONSTER) {
				Monsters m = ((Monsters) Labyrinth.getInstance().getElementOnSquare(this.posLigne + direction[0],
						this.posColonne + direction[1]));
				m.loseLifePoint(4);
				if (m.isDead()) {
					m.dieM();

				}
			}

		}
	}
}
