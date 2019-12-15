package Model;

import java.util.ArrayList;

public class Monsters extends Character {
	
	
	/*public Monsters() {
		this.type = Utilitaires.MONSTERS;
	}*/
	
	public Monsters(int posLigne, int posColonne) {
		super(posLigne, posColonne);
		this.type = Constants.MONSTER;
	
	}
	

	
	
	@Override
	public boolean deplacementPossible(int[] direction) {
		// TODO Auto-generated method stub
		if (Labyrinth.getInstance().getElementOnSquare(this.getPosLigne() + direction[0], this.getPosColonne() + direction[1])
				.getType() == Constants.EMPTY) {
			return true;

		} 
		return false;
	
	}

	
	
	
}
