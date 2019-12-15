package Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Labyrinthe {
	private ElementLab[][] grid;
	private int nbColonnes;
	private int nbLignes;
	private Heros heros;
	private static ArrayList<ElementLab> listeElement;

	private static ArrayList<Monsters> listeMonsters;

	private Labyrinthe() throws IOException {

		BufferedReader reader = new BufferedReader(new FileReader("Labyrinthe.txt"));
		String lec;
		lec = reader.readLine();
		String[] dimensions = lec.split(" ");

		nbLignes = Integer.parseInt(dimensions[0]);
		nbColonnes = Integer.parseInt(dimensions[1]);
		this.grid = new ElementLab[nbLignes][nbColonnes];
		this.listeElement = new ArrayList<ElementLab>();
		this.listeMonsters = new ArrayList<Monsters>();

		int i = 0;
		while ((lec = reader.readLine()) != null) {
			for (int j = 0; j < lec.length(); j++) {
				switch (lec.charAt(j)) {

				case Utilitaires.MONSTERS:
					listeElement.add(new Monsters(i, j));
					listeMonsters.add(new Monsters(i, j)); // faire liste
																	// de hros
																	// et de
																	// piège...et
																	// concatener
																	// avec
																	// listelements
					break;

				case Utilitaires.HEROS:
					this.heros = new Heros(i, j);
					listeElement.add(this.heros);
					break;

				case Utilitaires.MUR:
					listeElement.add(new Mur(i, j));
					break;

				case Utilitaires.VIDE:
					listeElement.add(new Vide(i, j));
					break;

				case Utilitaires.TRAP:
					listeElement.add(new Trap(i, j));
					break;
				default:
					break;

				}
			}
			i++;

		}

		for (ElementLab e : this.listeElement) {
			this.grid[e.getPosLigne()][e.getPosColonne()] = e;

		}
	}

	
	private static Labyrinthe INSTANCE;
	static {
		try {
			INSTANCE = new Labyrinthe();
		} catch (Exception e) {

		}
	} 

	public static Labyrinthe getInstance() {
		return INSTANCE;
	}

	public ElementLab getElementOnCase(int ligne, int colonne) {
		if (ligne >= 0 && ligne <= nbLignes && colonne >= 0 && colonne <= nbColonnes) {
			return grid[ligne][colonne];
		}
		System.out.println("En dehors des limites");
		return null;

	}

	public Heros getHeros() {
		return this.heros;
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

	public void setElementOnCase(int ligne, int colonne, ElementLab element) {
		grid[ligne][colonne] = element;

	}

	public ElementLab[][] getGrid() {
		return grid;
	}

	public void setGrid(ElementLab[][] grid) {
		this.grid = grid;
	}

	public static ArrayList<Monsters> getListeMonsters() {
		return listeMonsters;
	}

	public ArrayList<ElementLab> getListeElement() {
		return listeElement;
	}

	public void setListeElement(ArrayList<ElementLab> listeElement) {
		this.listeElement = listeElement;
	}

	public int getNbColonnes() {
		return nbColonnes;
	}

	public void setNbColonnes(int nbColonnes) {
		this.nbColonnes = nbColonnes;
	}

	public int getNbLignes() {
		return nbLignes;
	}

	public void setNbLignes(int nbLignes) {
		this.nbLignes = nbLignes;
	}

}
