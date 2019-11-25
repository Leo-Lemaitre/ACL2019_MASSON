import java.util.Vector;


import Model.Game;

public class Main {

	public static void main(String[] args) {

			Game g=new Game();
			g.play();

			Vector<String> lab = Generator.labyrinthe();

			System.out.println(lab);
		

			//System.out.println(lab);
			Generator.affichage_labyrinthe(lab);
			
			
	}
}
