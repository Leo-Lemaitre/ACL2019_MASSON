package Model;

import java.util.Observable;
import java.util.Observer;

public class Heros extends Character {

	public Heros() {
		this.posColonne = 5;
		this.posLigne = 5;
		this.type = Utilitaires.HEROS;
	}

	@Override
	public boolean deplacementPossible(int[] direction) {
		if (Labyrinthe.getTypeOfCase(this.getPosLigne() + direction[0],
				this.getPosColonne() + direction[1]) == Utilitaires.VIDE) {
			return true;
		} else {
			if (Labyrinthe.getTypeOfCase(this.getPosLigne() + direction[0],
					this.getPosColonne() + direction[1]) == Utilitaires.TRAP) {
			Trap.effect();
				return true;
			}
		}

		return false;
	}

}
