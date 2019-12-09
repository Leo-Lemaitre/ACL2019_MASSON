import java.io.IOException;
import java.util.Vector;

import Model.Game;
import Model.Labyrinthe;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {
		//False pour affichage console
		boolean gui=true;
		Game g = new Game(gui);
		g.play();
	}
}
