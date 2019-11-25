package Model;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Vector<String> lab = Labyrinthe.labyrinthe();
		//System.out.println(lab);
		/*Labyrinthe.affichage(lab);
		Heros.mettre_Heros_sur_plateau(lab);
		Labyrinthe.affichage(lab);*/
		Labyrinthe lab = new Labyrinthe();
		Heros.mettre_Heros_sur_plateau(lab);
		//System.out.println(lab);
	}

}
