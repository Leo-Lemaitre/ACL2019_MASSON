package Model;

import java.util.ArrayList;

public class Trap extends Trigger {

	public Trap(int posColonne, int posLigne) {
		this.posColonne = posColonne;
		this.posLigne = posLigne;
		this.type = Utilitaires.TRAP;

	}

	public static void effect() {
		Labyrinthe.setTypeOfCase((int) (Math.random() * 20), (int) (Math.random() * 40), Utilitaires.MUR);
	};

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
