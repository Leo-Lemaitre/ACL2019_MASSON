package Model;
/**
 * Classe Empty qui represente les cases vides du Labyrinthe
 *
 */
public class Empty extends ElementLab {

	public Empty(int posLigne, int posColonne) {
		super(posLigne,posColonne);
		this.type = Constants.EMPTY;
		this.imageName="Grass.png";
	}
	
	
}
