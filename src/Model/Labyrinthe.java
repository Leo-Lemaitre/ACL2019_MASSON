package Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Vector;

public class Labyrinthe {
	private static char[][] grid;
	private static int nbColonnes;
	private static int nbLignes;

	public Labyrinthe() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("Labyrinthe.txt"));
		String lec;
		lec = reader.readLine();
		String[] dimensions = lec.split(" ");

		nbLignes = Integer.parseInt(dimensions[0]);
		nbColonnes = Integer.parseInt(dimensions[1]);
		this.grid = new char[nbLignes][nbColonnes];

		int i = 0;
		while ((lec = reader.readLine()) != null) {
			for (int j = 0; j < lec.length(); j++) {
				this.grid[i][j] = lec.charAt(j);
			}
			i++;

		}
	}

	public static char getTypeOfCase(int ligne, int colonne) {
		if (ligne >= 0 && ligne <= nbLignes && colonne >= 0 && colonne <= nbColonnes) {
			return grid[ligne][colonne];
		}
		System.out.println("En dehors des limites");
		return '?';

	}

	@Override
	public String toString() {
		String str = "";
		for (int i = 0; i < nbLignes; i++) {
			for (int j = 0; j < nbColonnes; j++) {
				str += grid[i][j];
			}
			str += "\n";
		}

		return str;
	}

	public static void setTypeOfCase(int ligne, int colonne, char type) {
		grid[ligne][colonne] = type;

	}

	public char[][] getGrid() {
		return grid;
	}

	public void setGrid(char[][] grid) {
		this.grid = grid;
	}

	public int getNbColonnes() {
		return nbColonnes;
	}

	public void setNbColonnes(int nbColonnes) {
		Labyrinthe.nbColonnes = nbColonnes;
	}

	public int getNbLignes() {
		return nbLignes;
	}

	public void setNbLignes(int nbLignes) {
		Labyrinthe.nbLignes = nbLignes;
	}

}
