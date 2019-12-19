package Model;

public class Treasure extends Trigger {

	boolean treasureOwned;

	public Treasure(int posLigne, int posColonne) {
		super(posLigne, posColonne);
		this.type = Constants.TREASURE;
		this.treasureOwned = false;
	}

	// @Override
	public void effect() {
		treasureOwned = true;
		System.out.println("Tresor trouve : FIN DU JEU");
	}

	public boolean isTreasureOwned() {
		return treasureOwned;
	}

	public void setTreasureOwned(boolean treasureOwned) {
		this.treasureOwned = treasureOwned;
	}

}
