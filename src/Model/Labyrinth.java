
package Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Classe Labyrinthe sous forme de singleton qui contient tous les elements
 * presents sur le plateau
 */
public class Labyrinth {
	/**
	 * 
	 */
	private ElementLab[][] grid;
	/*
	 * 
	 */
	private int nbColumns;
	/*
	 * 
	 */
	private int nbLines;
	/*
	 * 
	 */
	private Hero hero;
	/*
	 * 
	 */
	private static ArrayList<ElementLab> listElement;
	/*
	 * 
	 */
	private static ArrayList<Monsters> listMonsters;

	/**
	 * Constructeur qui initialise le Labyrinthe
	 * 
	 * @throws IOException
	 */
	private Labyrinth() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("Labyrinthe.txt"));
		String lec = reader.readLine();
		String[] dimensions = lec.split(" ");

		nbLines = Integer.parseInt(dimensions[0]);
		nbColumns = Integer.parseInt(dimensions[1]);
		this.grid = new ElementLab[nbLines][nbColumns];
		this.listElement = new ArrayList<ElementLab>();
		this.listMonsters = new ArrayList<Monsters>();

		int i = 0;
		while ((lec = reader.readLine()) != null) {
			for (int j = 0; j < lec.length(); j++) {
				switch (lec.charAt(j)) {

				case Constants.MONSTER:
					listElement.add(new Monsters(i, j));
					listMonsters.add(new Monsters(i, j)); // faire liste
															// de hros
															// et de
															// piège...et
															// concatener
															// avec
															// listelements
					break;

				case Constants.HERO:
					this.hero = new Hero(i, j);
					listElement.add(this.hero);
					break;

				case Constants.WALL:
					listElement.add(new Wall(i, j));
					break;

				case Constants.EMPTY:
					listElement.add(new Empty(i, j));
					break;

				case Constants.TRAP:
					listElement.add(new Trap(i, j));
					break;
				default:
					break;

				}
			}
			i++;

		}

		for (ElementLab e : this.listElement) {
			this.grid[e.getPosLigne()][e.getPosColonne()] = e;

		}
	}

	/**
	 * Initialisatiob du Labyritnhe
	 */
	private static Labyrinth INSTANCE;
	static {
		try {
			INSTANCE = new Labyrinth();
		} catch (Exception e) {

		}
	}
	/**
	 * Point d'acces universelle à l instance du labyrinthe
	 * @return l instance du labyrinthe
	 */
	public static Labyrinth getInstance() {
		return INSTANCE;
	}

	/**
	 * Methode permettant de recuperer l'element sur une case donnee
	 * @param ligne
	 * @param colonne
	 * @return l'element present sur la case
	 */
	public ElementLab getElementOnSquare(int ligne, int colonne) {
		if (ligne >= 0 && ligne <= nbLines && colonne >= 0 && colonne <= nbColumns) {
			return grid[ligne][colonne];
		}
		System.out.println("En dehors des limites");
		return null;

	}

	public Hero getHeros() {
		return this.hero;
	}

	@Override
	public String toString() {
		String str = "";
		for (int i = 0; i < nbLines; i++) {
			for (int j = 0; j < nbColumns; j++) {
				str += grid[i][j];
			}
			str += "\n";
		}

		return str;
	}

	public void setElementOnSquare(int line, int column, ElementLab element) {
		grid[line][column] = element;

	}

	public ElementLab[][] getGrid() {
		return grid;
	}

	public void setGrid(ElementLab[][] grid) {
		this.grid = grid;
	}

	public static ArrayList<Monsters> getListMonsters() {
		return listMonsters;
	}

	public ArrayList<ElementLab> getListElement() {
		return listElement;
	}

	public void setListElement(ArrayList<ElementLab> listElement) {
		this.listElement = listElement;
	}

	public int getNbColumns() {
		return nbColumns;
	}

	public void setNbColumns(int nbColonnes) {
		this.nbColumns = nbColonnes;
	}

	public int getNbLines() {
		return nbLines;
	}

	public void setNbLines(int nbLignes) {
		this.nbLines = nbLignes;
	}

}
