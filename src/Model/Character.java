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
		this.setPosX(this.getPosX()+direction[0]);
		this.setPosY(this.getPosY()+direction[1]);
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
}
