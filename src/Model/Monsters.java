package Model;

import java.util.ArrayList;

public class Monsters extends Character {
	
	
	/*public Monsters() {
		this.type = Utilitaires.MONSTERS;
	}*/
	
	public Monsters(int posLigne, int posColonne, Labyrinthe lab) {
		super(posLigne, posColonne, lab);
		this.type = Utilitaires.MONSTERS;
	
	}
	

	
	
	@Override
	public boolean deplacementPossible(int[] direction) {
		// TODO Auto-generated method stub
		if (this.lab.getElementOnCase(this.getPosLigne() + direction[0], this.getPosColonne() + direction[1])
				.getType() == Utilitaires.VIDE) {
			return true;

		} 
		return false;
	
	}

	
	
	
}
