package Model;

/**
 * Classe Healer qui herite de la classe Trigger qui s occupe de l effet lors de
 * leur activation
 */

public class Healer extends Trigger {
	
	public Healer(int posLigne, int posColonne) {
		super(posLigne, posColonne);
		this.type = Constants.HEALER;
		this.imageName = "heart_ok";

	}

	@Override
	public void effect() {
		Labyrinth.getInstance().getHeros().addLifePoint(2);
		System.out.println("Healer declenche");
	}
}
