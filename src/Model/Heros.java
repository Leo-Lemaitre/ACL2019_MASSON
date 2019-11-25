package Model;

import java.util.Vector;

public class Heros extends Character {

	
	
	public Heros() {
		this.posX=1;
		this.posY=1;
	}
	
	
	
	public void mettre_Heros_sur_plateau(Labyrinthe lab, int x, int y) {
		lab.setTypeOfCase(x,y,'O');
	}



	@Override
	public boolean deplacementPossible(int[] direction) {
		if(Labyrinthe.getTypeOfCase(this.getPosX() + direction[0],this.getPosY() + direction[1])== ' ')
		return true;
		return false;
	}
	
	
}
