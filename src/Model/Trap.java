package Model;

import java.util.ArrayList;

public class Trap extends Trigger {

	public Trap(int posLigne, int posColonne) {
		super(posLigne, posColonne);
		this.type = Constants.TRAP;

	}

	@Override
	public void effect() {
		Labyrinth.getInstance().getHeros().loseLifePoint(2);
		System.out.println("Piege declenche");
	}

	/*
	 * if(Heros.getPosLigne() == this.posLigne && Heros.getPosColonne()==
	 * this.posColonne ) {
	 * 
	 * Labyrinthe.setTypeOfCase(this.getPosLigne(), this.getPosColonne(),
	 * Utilitaires.VIDE); Heros.setPosLigne(); Heros.setPosColonne();
	 * Labyrinthe.setTypeOfCase(this.getPosLigne(), this.getPosColonne(), type);
	 * update(); } else { System.out.println("Deplacement impossible"); } }
	 */

}
