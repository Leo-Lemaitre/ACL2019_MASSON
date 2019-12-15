package Model;

import java.util.Observable;

public abstract class Character extends ElementLab {

	public Character(int posLigne, int posColonne) {
		super(posLigne,posColonne);
		
	}
	protected int lifePoint;

	public void changerPosition(int[] direction) {
		if (deplacementPossible(direction)) {
			Labyrinthe.getInstance().setElementOnCase(this.getPosLigne(), this.getPosColonne(), new Vide(this.getPosLigne(), this.getPosColonne()));
			this.setPosLigne(this.getPosLigne() + direction[0]);
			this.setPosColonne(this.getPosColonne() + direction[1]);
			Labyrinthe.getInstance().setElementOnCase(this.getPosLigne(), this.getPosColonne(), this);
			update();
		} else {
			System.out.println("Deplacement impossible");
			update();
		}
	}

	public abstract boolean deplacementPossible(int[] direction);


	public int getLifePoint() {
		return lifePoint;
	}

	public void setLifePoint(int lifePoint) {
		this.lifePoint = lifePoint;
	}

}
