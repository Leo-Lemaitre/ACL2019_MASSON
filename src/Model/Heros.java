package Model;

public class Heros extends Character {

	
	
	public Heros() {
		this.posColonne=5;
		this.posLigne=5;
		this.type=Utilitaires.HEROS;
	}
	
	
	
	public void mettre_Heros_sur_plateau(Labyrinthe lab, int ligne, int colonne) {
		lab.setTypeOfCase(ligne,colonne,'O');
	}



	@Override
	public boolean deplacementPossible(int[] direction) {
		if(Labyrinthe.getTypeOfCase(this.getPosLigne() + direction[0],this.getPosColonne() + direction[1])==Utilitaires.VIDE)
		return true;
		return false;
	}
	
}
