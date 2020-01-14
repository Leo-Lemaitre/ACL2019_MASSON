package Model;

import java.util.ArrayList;

public class Trap extends Trigger {

	public Trap(int posLigne, int posColonne) {
		super(posLigne, posColonne);
		this.type = Constants.TRAP;
		this.imageName="trap_ok";

	}

	@Override
	public void effect() {
		Labyrinth.getInstance().getHeros().loseLifePoint(2);
		System.out.println("Piege declenche");
	}


}
