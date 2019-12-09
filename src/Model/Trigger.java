package Model;

import java.util.ArrayList;

public abstract class Trigger {

	protected int posLigne;
	protected int posColonne;
	protected char type;
	
	//public abstract void effect();


	public static void AddTrigger(ArrayList<Trigger> trigger) {
		trigger.add(new Trap(14,5));
		trigger.add(new Trap(9,7));

	}
	

	
	public void mettre_sur_plateau(Labyrinthe lab, int ligne, int colonne) {
		lab.setTypeOfCase(ligne, colonne, this.type);
		update();
	}

	public void update() {
		
	}
	
	public int getPosLigne() {
		return posLigne;
	}

	public void setPosLigne(int posLigne) {
		this.posLigne = posLigne;
	}

	public int getPosColonne() {
		return posColonne;
	}

	public void setPosColonne(int posColonne) {
		this.posColonne = posColonne;
	}
}
