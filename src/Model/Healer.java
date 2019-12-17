package Model;

public class Healer extends Trigger {

	public Healer(int posLigne, int posColonne) {
		super(posLigne, posColonne);
		this.type = Constants.HEALER;

	}

	@Override
	public void effect() {
		Labyrinth.getInstance().getHeros().addLifePoint(2);
		System.out.println("Healer declenche");
	}
}
