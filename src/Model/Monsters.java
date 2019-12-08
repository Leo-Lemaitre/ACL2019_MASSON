package Model;

import java.util.ArrayList;

public class Monsters extends Character {
	
	
	
	public Monsters(int posColonne, int posLigne) {
		this.posColonne = posColonne;
		this.posLigne = posLigne;
		this.type = Utilitaires.MONSTERS;
	
	}
	
	public static void AddMonsters(ArrayList<Monsters> monsters) {
		monsters.add(new Monsters(14,4));
		monsters.add(new Monsters(6,8));

	}
	
	
	@Override
	public boolean deplacementPossible(int[] direction) {
		// TODO Auto-generated method stub
		return true;
	}

	
	
}
