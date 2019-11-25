package Model;

import java.util.Vector;

public class Heros extends Character {

	
	
	public Heros() {
		this.posX=1;
		this.posY=1;
	}
	
	
	
	public static void mettre_Heros_sur_plateau(Labyrinthe lab) {
		lab.getGrid()[1][1]='O';
	}
	
	
}
