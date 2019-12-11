package Model;

import java.util.ArrayList;

public class Trap extends Trigger {

	public Trap(int posLigne, int posColonne, Labyrinthe lab) {
		super(posLigne, posColonne, lab);
		this.type = Utilitaires.TRAP;

	}

	@Override
	public void effect() {
		// TODO Auto-generated method stub
		
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
