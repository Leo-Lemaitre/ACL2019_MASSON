package Model;

import java.util.Observable;
import java.util.Observer;

public class Hero extends Character {

	public Hero(int posLigne, int posColonne, int lifepoint) {
		super(posLigne, posColonne,lifepoint);
		this.type = Constants.HERO;
	}

	@Override
	public boolean deplacementPossible(int[] direction) {
		if (Labyrinth.getInstance().getElementOnSquare(this.getPosLigne() + direction[0], this.getPosColonne() + direction[1])
				.getType() == Constants.EMPTY) {
			return true;

		} else {
			if (Labyrinth.getInstance().getElementOnSquare(this.getPosLigne() + direction[0], this.getPosColonne() + direction[1])
					.getType() == Constants.TRAP) {
				((Trigger)Labyrinth.getInstance().getElementOnSquare(this.getPosLigne() + direction[0], this.getPosColonne() + direction[1])).effect();
				return true;
			}
		}

		return false;
	}

}
