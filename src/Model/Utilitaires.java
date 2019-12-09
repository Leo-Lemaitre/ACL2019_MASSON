package Model;

public final class Utilitaires {

	public static final char MUR = 'X';
	public static final char VIDE = ' ';
	public static final char HEROS = 'O';
	public static final char MONSTERS = 'Y';
	public static final char TRAP = 'P';

	// Ligne puis colonne
	public final static int[] HAUT = new int[] { -1, 0 };
	public final static int[] BAS = new int[] { 1, 0 };
	public final static int[] GAUCHE = new int[] { 0, -1 };
	public final static int[] DROITE = new int[] { 0, 1 };
	public final static int[][] DIRECTIONS = new int[][] { HAUT, GAUCHE, BAS, DROITE };

	public final static int tailleCaseLaby = 40;
	

}