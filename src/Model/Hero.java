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
		ElementLab element=Labyrinth.getInstance().getElementOnSquare(this.getPosLigne() + direction[0], this.getPosColonne() + direction[1]);
		if(element==null) {
			return false;
		}
		if (element.getType()== Constants.EMPTY) {
			return true;

		} else {
			if (element.getType()== Constants.TRAP || element.getType()== Constants.HEALER) {
				((Trigger)Labyrinth.getInstance().getElementOnSquare(this.getPosLigne() + direction[0], this.getPosColonne() + direction[1])).effect();
				return true;
			}
		}

		return false;
	}

}
