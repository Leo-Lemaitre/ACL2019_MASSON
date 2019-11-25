package Model;

public final class Utilitaires  {

	  /** Opposite of {@link #FAILS}.  */
	  public static final char MUR = 'X';
	  public static final char VIDE = ' ';

		public final static int[] HAUT = new int[] { 0, -1 };
		public final static int[] BAS = new int[] { 0, 1 };
		public final static int[] GAUCHE = new int[] { -1, 0 };
		public final static int[] DROITE = new int[] { 1, 0 };
		public final static int[][] DIRECTIONS = new int[][] { HAUT, GAUCHE, BAS, DROITE };
	  
}