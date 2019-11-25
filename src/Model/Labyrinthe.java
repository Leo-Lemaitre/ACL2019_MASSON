package Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Vector;

public class Labyrinthe {
	
	private char[][] grid;
	private int Labylength;
	private int labyWidth;
	
	
	
	public  Labyrinthe() throws IOException {
			
	        BufferedReader reader = new BufferedReader(new FileReader("Labyrinthe.txt"));
	        this.grid=new char[7][20];

	        String lec;
	        int i =0;
	        while ((lec = reader.readLine()) != null){
	        	System.out.println(lec);
	            for(int j = 0;j< lec.length(); j++){
	            	
	            	if(lec.charAt(i)=='X') {
	            		this.grid[i][j]='X';
	            	}
	            	if(lec.charAt(i)==' ') {
	            		this.grid[i][j]=' ';
	            	}
	            }
	            i++;
	              
	          
	        }
	    }
		/*
		//String[][] labyrinthe = new String[20][7];	
		Vector <Vector<String>> labyrinthe = new Vector <Vector<String>>();
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
		return labyrinthe;*/
	
	
	public char[][] getGrid() {
		return grid;
	}
	public void setGrid(char[][] grid) {
		this.grid = grid;
	}
	public int getLabylength() {
		return Labylength;
	}
	public void setLabylength(int labylength) {
		Labylength = labylength;
	}
	public int getLabyWidth() {
		return labyWidth;
	}
	public void setLabyWidth(int labyWidth) {
		this.labyWidth = labyWidth;
	}
	
	public static void affichage(Vector<String> lab) {
		for(int i=0;i<7;i++) {
			System.out.println(lab.get(i));
		}
	
	}


	@Override
	public String toString() {
		String str = "";
		for(int i = 0; i< grid.length; i++) {
			for(int j = 0; j< grid.length; j++) {
				str+=grid[i][j];
			}
			str+="\n";
		}
		
		return str;
	}
	

}
