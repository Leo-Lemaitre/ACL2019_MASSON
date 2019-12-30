import java.io.IOException;
import java.util.Vector;

import Model.Game;
import Model.Labyrinth;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {
		Game g = new Game(true);
		g.play();
	}
}
