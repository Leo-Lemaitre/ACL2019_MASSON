package Model;

import java.util.ArrayList;

/**
 * Classe Trap qui herite de la classe Trigger qui s occupe de l effet des
 * pieges lors de leur activation
 */

public class Trap extends Trigger {

	/**
	 * Constructeur qui initialise un piege a une position donnee posLigne et
	 * posLigne en reutilisant le superconstructeur de la classe Trigger en
	 * precisant le type trap
	 * 
	 * @param posLigne
	 * @param posColonne
	 */

	public Trap(int posLigne, int posColonne) {
		super(posLigne, posColonne);
		this.type = Constants.TRAP;
		this.imageName = "trap_ok";

	}
	
	

	@Override
	public void effect() {
		Labyrinth.getInstance().getHeros().loseLifePoint(2);
		System.out.println("Piege declenche");
	}

}
