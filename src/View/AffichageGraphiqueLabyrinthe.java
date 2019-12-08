package View;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Model.Labyrinthe;
import Model.Utilitaires;

public class AffichageGraphiqueLabyrinthe implements GamePainter {

	private Labyrinthe lab;
	public ImageIcon Arbre1 = new ImageIcon("src/images/Arbre1.png");
	
	Image imArbre1 = Arbre1.getImage();
	
	
	

	public AffichageGraphiqueLabyrinthe(Labyrinthe labyrinthe) {
		this.lab = labyrinthe;
	}

	public void draw(BufferedImage image) {
		
		Graphics2D g = (Graphics2D) image.getGraphics();
		for (int ligne = 0; ligne < lab.getNbLignes(); ligne++) {
			for (int colonne = 0; colonne < lab.getNbColonnes(); colonne++) {
				switch (lab.getTypeOfCase(ligne, colonne)) {
				case Utilitaires.VIDE:
					g.setColor(Color.WHITE);
					break;
				case Utilitaires.HEROS:
					g.setColor(Color.YELLOW);
					break;
				case Utilitaires.MONSTERS:
					g.setColor(Color.BLUE);
					break;
				
				}
				g.fillRect(colonne* Utilitaires.tailleCaseLaby, ligne * Utilitaires.tailleCaseLaby,
						Utilitaires.tailleCaseLaby, Utilitaires.tailleCaseLaby);
				
			}
		}
		for (int ligne = 0; ligne < lab.getNbLignes(); ligne++) {
			for (int colonne = 0; colonne < lab.getNbColonnes(); colonne++) {
				if(lab.getTypeOfCase(ligne,colonne)== Utilitaires.MUR) {
					g.drawImage(imArbre1,colonne* Utilitaires.tailleCaseLaby-7,ligne * Utilitaires.tailleCaseLaby-30,null);
				}
			}
		}	
		g.dispose();
	}

	@Override
	public int getWidth() {
		return Utilitaires.tailleCaseLaby * lab.getNbColonnes();
	}

	@Override
	public int getHeight() {
		return Utilitaires.tailleCaseLaby * lab.getNbLignes();
	}
}