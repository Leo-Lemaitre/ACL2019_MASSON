package Model;

import java.util.ArrayList;

/**
 * Classe Monsters qui herite de la classe Character qui s occupe du deplacement
 * des monstres
 */

public class Monsters extends Character {

	/**
	 * Constructeur qui initialise un monstre a une position donnee posLigne
	 * posLigne et en lui donnant des points de vie en reutilisant le
	 * superconstructeur de la classe Character en precisant le type monster
	 * 
	 * @param posLigne posX 
	 * @param posColonne posY 
	 * @param lifepoint nombre de points de vie
	 */

	public Monsters(int posLigne, int posColonne, int lifepoint) {
		super(posLigne, posColonne, lifepoint);
		this.type = Constants.MONSTER;
		this.imageName = "Orc";

	}

	/**
	 * Methode permettant de verifier si le deplacement est possible en s assurant
	 * que la case est vide
	 * 
	 * @param direction direction dans laquelle va s effectuer le deplacement
	 * @return boolean vaut vrai si le deplacement est possible
	 */

	@Override
	public boolean deplacementPossible(int[] direction) {
		if (Labyrinth.getInstance()
				.getElementOnSquare(this.getPosLigne() + direction[0], this.getPosColonne() + direction[1])
				.getType() == Constants.EMPTY) {
			return true;
		}
		return false;

	}

	public int[] getDirectionCloserToTheHero() {
		double min = this.distanceWithElement(Labyrinth.getInstance().getHeros());
		int[] direction = { 0, 0 };
		// si il est � port�e il ne se deplace pas
		if (min == 1) {
			return direction;
		}
		// on essaie de diminuer la distance
		for (int[] d : Constants.DIRECTIONS) {
			if (deplacementPossible(d)) {
				double test = Labyrinth.getInstance()
						.getElementOnSquare(this.getPosLigne() + d[0], this.getPosColonne() + d[1])
						.distanceWithElement(Labyrinth.getInstance().getHeros());
				if (test <= min) {
					return d;
				}
			}

		}

		// si on ne peut pas minimiser la distance alors on prend la premi�re
		// admissible
		if (direction[0] == 0 && direction[1] == 0) {
			for (int[] d : Constants.DIRECTIONS) {
				if (deplacementPossible(d)) {
					return d;
				}

			}
		}

		return direction;
	}

	/**
	 * Methode permettant aux monstres d attaquer le hero
	 */

	public void attack() {
		for (int[] direction : Constants.DIRECTIONS) {
			if (Labyrinth.getInstance().getElementOnSquare(this.posLigne + direction[0], this.posColonne + direction[1])
					.getType() == Constants.HERO) {

				Labyrinth.getInstance().getHeros().loseLifePoint(1);

			}

		}

	}

}
