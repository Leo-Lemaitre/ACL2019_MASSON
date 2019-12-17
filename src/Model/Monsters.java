package Model;

import java.util.ArrayList;

public class Monsters extends Character {

	public Monsters(int posLigne, int posColonne,int lifepoint) {
		super(posLigne, posColonne,lifepoint);
		this.type = Constants.MONSTER;

	}

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
