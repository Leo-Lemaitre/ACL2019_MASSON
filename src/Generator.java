import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Generator {
	public static void labyrinthe() {
		String fichier = "labyrinthe.txt";
		Scanner sc = null;
		try {
			sc = new Scanner(new File(fichier));
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(sc.hasNextLine()) {
			String uneligne = sc.nextLine();
			Scanner scLigne = new Scanner(uneligne);
			System.out.println(scLigne.hasNext());
			}
	}
	
}
