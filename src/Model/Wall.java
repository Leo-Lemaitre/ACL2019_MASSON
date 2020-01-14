package Model;
/**
 * Classe Wall qui herite de Element Lab et qui correspond aux murs du labyrinthe
 *
 */
public class Wall extends ElementLab{

	public Wall(int posLigne, int posColonne) {
		super(posLigne,posColonne);
		this.type = Constants.WALL;
		this.imageName="Tree2";
	}
	
}
