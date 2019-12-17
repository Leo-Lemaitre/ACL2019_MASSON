package Model;

import java.util.ArrayList;

public abstract class Trigger extends ElementLab {

	public Trigger(int posLigne, int posColonne) {
		super(posLigne, posColonne);
	}

	public abstract void effect();

}
