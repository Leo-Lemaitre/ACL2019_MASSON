package Model;

public abstract class Character {
	protected int posX;
	protected int posY;
	protected int lifePoint;

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public void changerPosition(int[] direction) {
		if (deplacementPossible(direction)) {
			Labyrinthe.setTypeOfCase(this.getPosY(), this.getPosX(), ' ');
			this.setPosX(this.getPosX() + direction[0]);
			this.setPosY(this.getPosY() + direction[1]);
			// changer le O pour les monstres variables
			Labyrinthe.setTypeOfCase(this.getPosY(),this.getPosX(), 'O');
		} else {
			System.out.println("Deplacement impossible");
		}
	}

	public abstract boolean deplacementPossible(int[] direction);

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
}
