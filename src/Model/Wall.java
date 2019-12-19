package Model;

public class Wall extends ElementLab{

	public Wall(int posLigne, int posColonne) {
		super(posLigne,posColonne);
		this.type = Constants.WALL;
		this.imageName="Arbre1.png";
	}
	
}
