package Model;

public final class Constants {

	public static final char WALL = 'X';
	public static final char EMPTY = ' ';
	public static final char HERO = 'O';
	public static final char MONSTER = 'Y';
	public static final char TRAP = 'P';

	// Ligne puis colonne
	public final static int[] UP = new int[] { -1, 0 };
	public final static int[] DOWN = new int[] { 1, 0 };
	public final static int[] LEFT = new int[] { 0, -1 };
	public final static int[] RIGHT = new int[] { 0, 1 };
	public final static int[][] DIRECTIONS = new int[][] { UP, LEFT, DOWN, RIGHT };

	public final static int SIZESQUARE = 40;
	

}