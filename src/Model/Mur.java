package Model;

public class Mur extends ElementLab{

	

	
	public Mur(int posLigne, int posColonne, Labyrinthe lab) {
		super(posLigne,posColonne, lab);
		this.type = Utilitaires.MUR;
		
		
	}
	
}
