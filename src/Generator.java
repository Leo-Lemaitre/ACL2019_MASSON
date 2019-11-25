import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class Generator {
	public static Vector<String> labyrinthe() {

		//String[][] labyrinthe = new String[20][7];	
		Vector <String> labyrinthe = new Vector <String>();
		String fichier = "labyrinthe.txt";
		Scanner sc = null;
		int j=0;
		try {
			sc = new Scanner(new File(fichier));
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(sc.hasNextLine() && j<20) {
			
			String uneligne = sc.nextLine();
			Scanner scLigne = new Scanner(uneligne);
			//System.out.println(scLigne.hasNext());
			// Création du labyrinthe à partir du fichier texte
			//System.out.println(scLigne.nextLine());
			labyrinthe.add( (scLigne.nextLine()));
			
		}
		return labyrinthe;
	}





public static void affichage_labyrinthe(Vector<String> lab) {
	/*String fichier = "labyrinthe.txt";
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
		//System.out.println(scLigne.hasNext());
		// Affichage du labyrinthe
		System.out.println(scLigne.nextLine());
	}*/
	//lab2[] = convertVectorToArray(lab);
	for(int i=0;i<7;i++) {
		for(int j=0;j<20;j++) {
			System.out.println();
		}
	}

}

}
