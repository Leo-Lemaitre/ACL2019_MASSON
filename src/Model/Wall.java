package Model;

public class Wall extends ElementLab{

	public Wall(int posLigne, int posColonne) {
		super(posLigne,posColonne);
		this.type = Constants.WALL;
		this.fileImage="src/images/Arbre1.png";
	}
	
}
