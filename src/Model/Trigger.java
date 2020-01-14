package Model;

import java.util.ArrayList;

/**
 * Classe abstraite qui represente les elements que le hero peut declencher
 *
 */
public abstract class Trigger extends ElementLab {

	public Trigger(int posLigne, int posColonne) {
		super(posLigne, posColonne);
	}

	public abstract void effect();

}
