package Model;

import java.util.ArrayList;

public class Trap extends Trigger{
	
	
	public Trap(int posColonne, int posLigne) {
		this.posColonne = posColonne;
		this.posLigne = posLigne;
		this.type = Utilitaires.TRAP;

	}

	

	public void effect() {
			Labyrinthe.setTypeOfCase(14, 5, Utilitaires.MUR);
			update();
		
		/*if(Heros.getPosLigne() == this.posLigne && Heros.getPosColonne()== this.posColonne ) {

					Labyrinthe.setTypeOfCase(this.getPosLigne(), this.getPosColonne(), Utilitaires.VIDE);
					Heros.setPosLigne();
					Heros.setPosColonne();
					Labyrinthe.setTypeOfCase(this.getPosLigne(), this.getPosColonne(), type);
					update();
				} else {
					System.out.println("Deplacement impossible");
				}
			}*/
		
	}
	
}


	

