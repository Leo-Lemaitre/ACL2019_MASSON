package Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Vector;

public class Labyrinthe {
	// A modifier enlever static
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

	public char[][] getGrid() {
		return grid;
	}

	public void setGrid(char[][] grid) {
		this.grid = grid;
	}

	public static char getTypeOfCase(int x, int y) {
		if (x >= 0 && x <= nbColonnes && y >= 0 && y <= nbLignes) {
			return grid[x][y];
		}
		System.out.println("En dehors des limites");
		return '?';

	}
	
	public static void setTypeOfCase(int x, int y, char type) {
		grid[x][y]=type;

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

}
