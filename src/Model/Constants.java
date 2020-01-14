package Model;

import java.util.List;

public final class Constants {

	public static final char WALL = 'X';
	public static final char EMPTY = ' ';
	public static final char HERO = 'O';
	public static final char MONSTER = 'Y';
	public static final char TRAP = 'P';
	public static final char HEALER = 'H';
	public static final char TREASURE = 'T';

	public final static int[] UP = new int[] { -1, 0 };
	public final static int[] DOWN = new int[] { 1, 0 };
	public final static int[] LEFT = new int[] { 0, -1 };
	public final static int[] RIGHT = new int[] { 0, 1 };
	public final static int[][] DIRECTIONS = new int[][] {UP,LEFT,DOWN,RIGHT};

	public final static int SIZESQUARE = 33;
	public final static String FILELAB = "src/Labyrinthe2.txt";
	public final static String FILETEST = "src/LabyrintheTest.txt";

	public final static int SPEEDMONSTERSEASY = 100;
	public final static int SPEEDMONSTERSINTERMEDIATE = 50;
	public final static int SPEEDMONSTERSHARD = 30;

}