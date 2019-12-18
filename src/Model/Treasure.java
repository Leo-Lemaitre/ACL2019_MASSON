package Model;

public class Treasure extends Trigger {

	public Treasure(int posLigne, int posColonne) {
		super(posLigne, posColonne);
		this.type = Constants.TREASURE;


		// TODO Auto-generated constructor stub
	}

	// @Override
	public void effect() {
		// TODO Auto-generated method stub
		System.out.println("Tresor trouve : FIN DU JEU");
	}

}
