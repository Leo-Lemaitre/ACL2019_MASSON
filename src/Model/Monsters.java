package Model;

import java.util.ArrayList;


/**
 * Classe Monsters qui herite de la classe Character qui 
 * s occupe du deplacement des monstres 
 */


public class Monsters extends Character {

	
	/**
	 * Constructeur qui initialise un monstre a une position donnee posLigne posLigne 
	 * et en lui donnant des points de vie en reutilisant le superconstructeur de 
	 * la classe Character en precisant le type monster
	 * @param posLigne 
	 * @param posColonne
	 * @param lifepoint
	 */
	
	public Monsters(int posLigne, int posColonne,int lifepoint) {
		super(posLigne, posColonne,lifepoint);
		this.type = Constants.MONSTER;

	}

	
	/**
	 * Methode permettant de verifier si le deplacement est possible 
	 * en s assurant que la case est vide 
	 * 
	 * @param direction
	 * @return boolean 
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

}
