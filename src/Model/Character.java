package Model;

import java.util.Observable;

public abstract class Character extends ElementLab {

	protected int lifePoint;
	public Character(int posLigne, int posColonne, int lifepoint) {
		super(posLigne, posColonne);
		this.lifePoint=10;

	}



	public void changePosition(int[] direction) {
		if (deplacementPossible(direction)) {
			Labyrinth.getInstance().setElementOnSquare(this.getPosLigne(), this.getPosColonne(),
					new Empty(this.getPosLigne(), this.getPosColonne()));
			this.setPosLigne(this.getPosLigne() + direction[0]);
			this.setPosColonne(this.getPosColonne() + direction[1]);
			Labyrinth.getInstance().setElementOnSquare(this.getPosLigne(), this.getPosColonne(), this);
			
		} else {
			// System.out.println("Deplacement impossible");
		}
		update();
	}

	public abstract boolean deplacementPossible(int[] direction);

	public int getLifePoint() {
		return lifePoint;
	}

	public void setLifePoint(int lifePoint) {
		this.lifePoint = lifePoint;
		update();
	}

	public void addLifePoint(int lifePoint) {
		this.lifePoint += lifePoint;
		update();
	}

	public void loseLifePoint(int lifePoint) {
		this.lifePoint -= lifePoint;
		update();
	}

}
