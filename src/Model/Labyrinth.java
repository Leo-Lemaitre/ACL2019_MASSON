
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
	 * attribut grille representant le labyrinthe avec pour chaque case un element
	 * du labyrinthe associe
	 */
	private ElementLab[][] grid;
	/*
	 * attribut representant le nombre de colonnes du labyrinthe
	 */
	private int nbColumns;
	/*
	 * attribut representant le nombre de lignes du labyrinthe
	 */
	private int nbLines;
	/*
	 * attribut de type Hero qui represente l unique hero du jeu
	 */
	private Hero hero;
	/*
	 * attribut liste qui contient tous les elements declenchables presents dans le
	 * labyrinthe
	 */
	private ArrayList<Trigger> listTriggers;
	/*
	 * attribut liste qui contient tous les elements presents dans le labyrinthe
	 */
	private static ArrayList<ElementLab> listElement;
	/*
	 * attribut liste qui contient tous les monstres presents dans le labyrinthe
	 */
	private static ArrayList<Monsters> listMonsters;

	/**
	 * Constructeur qui initialise le Labyrinthe a partir du fichier Labyrinthe.txt
	 * 
	 * @throws IOException si la lecture du fichier mene a une erreur
	 */
	private Labyrinth() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(Constants.FILELAB));
		String lec = reader.readLine();
		String[] dimensions = lec.split(" ");

		nbLines = Integer.parseInt(dimensions[0]);
		nbColumns = Integer.parseInt(dimensions[1]);
		this.grid = new ElementLab[nbLines][nbColumns];
		this.listElement = new ArrayList<ElementLab>();
		this.listMonsters = new ArrayList<Monsters>();
		this.listTriggers = new ArrayList<Trigger>();

		int i = 0;
		while ((lec = reader.readLine()) != null) {
			for (int j = 0; j < lec.length(); j++) {
				switch (lec.charAt(j)) {

				case Constants.MONSTER:
					listMonsters.add(new Monsters(i, j,5));
					break;

				case Constants.HERO:
					this.hero = new Hero(i, j,10);
					listElement.add(this.hero);
					break;

				case Constants.WALL:
					listElement.add(new Wall(i, j));
					break;

				case Constants.EMPTY:
					listElement.add(new Empty(i, j));
					break;

				case Constants.TRAP:
					listTriggers.add(new Trap(i,j));
					break;
					
				case Constants.HEALER:
					listTriggers.add(new Healer(i,j));
					break;
				default:
					break;

				}
			}
			i++;

		}

		listElement.addAll(listMonsters);
		listElement.addAll(listTriggers);
		for (ElementLab e : this.listElement) {
			this.grid[e.getPosLigne()][e.getPosColonne()] = e;
		}

	}

	/**
	 * Initialisation du Labyrinthe sous la forme de singleton
	 */
	private static Labyrinth INSTANCE;
	static {
		try {
			INSTANCE = new Labyrinth();
		} catch (Exception e) {

		}
	}

	/**
	 * Point d'acces universelle a l instance du labyrinthe
	 * 
	 * @return l instance du labyrinthe
	 */
	public static Labyrinth getInstance() {
		return INSTANCE;
	}

	/**
	 * Methode permettant de recuperer l'element sur une case donnee
	 * 
	 * @param ligne
	 * @param colonne
	 * @return l'element present sur la case
	 */
	public ElementLab getElementOnSquare(int ligne, int colonne) {
		if (ligne >= 0 && ligne <= nbLines && colonne >= 0 && colonne <= nbColumns) {
			return grid[ligne][colonne];
		}
		return null;

	}

	/**
	 * Methode toString qui affiche le labyrinthe
	 */
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

	/**
	 * Remplace une case du labyrinthe par un element
	 * 
	 * @param line    numero de ligne ou l element sera mis
	 * @param column  numero de colonne ou l element sera mis
	 * @param element element a ajouter au labyrinthe
	 */
	public void setElementOnSquare(int line, int column, ElementLab element) {
		grid[line][column] = element;

	}

	public Hero getHeros() {
		return this.hero;
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
