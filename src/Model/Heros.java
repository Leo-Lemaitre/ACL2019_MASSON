package Model;

import java.util.Observable;
import java.util.Observer;

public class Heros extends Character {

	public Heros(int posLigne, int posColonne, Labyrinthe lab) {
		super(posLigne, posColonne, lab);
		this.type = Utilitaires.HEROS;
	}

	@Override
	public boolean deplacementPossible(int[] direction) {
		if (this.lab.getElementOnCase(this.getPosLigne() + direction[0], this.getPosColonne() + direction[1])
				.getType() == Utilitaires.VIDE) {
			return true;

		} else {
			if (this.lab.getElementOnCase(this.getPosLigne() + direction[0], this.getPosColonne() + direction[1])
					.getType() == Utilitaires.TRAP) {
				((Trigger)this.lab.getElementOnCase(this.getPosLigne() + direction[0], this.getPosColonne() + direction[1])).effect();
				return true;
			}
		}

		return false;
	}

}
