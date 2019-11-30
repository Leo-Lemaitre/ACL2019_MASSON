package View;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import Model.Labyrinthe;
import Model.Utilitaires;

public class AffichageLabyrinthe implements GamePainter {

	private Labyrinthe lab;

	public AffichageLabyrinthe(Labyrinthe labyrinthe) {
		this.lab = labyrinthe;
	}

	public void draw(BufferedImage image) {
		System.out.println("Dessiner le beau labyrinthe");

		Graphics2D g = (Graphics2D) image.getGraphics();

		// g.setColor(Color.RED);
		// g.fillRect(0, 0, 10, 10);
		for (int ligne = 0; ligne < lab.getNbLignes(); ligne++) {
			for (int colonne = 0; colonne < lab.getNbColonnes(); colonne++) {

				// System.out.println("i= "+i+" j=" +j);
				switch (lab.getTypeOfCase(ligne, colonne)) {
				case Utilitaires.MUR:
					g.setColor(Color.BLACK);
					break;

				case Utilitaires.VIDE:
					g.setColor(Color.WHITE);
					break;
				case Utilitaires.HEROS:
					g.setColor(Color.YELLOW);
					break;
				}

				g.fillRect(colonne * Utilitaires.tailleCaseLaby, ligne * Utilitaires.tailleCaseLaby, Utilitaires.tailleCaseLaby, Utilitaires.tailleCaseLaby);

			}
		}

		g.dispose();

	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return Utilitaires.tailleCaseLaby*lab.getNbColonnes();
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return Utilitaires.tailleCaseLaby*lab.getNbLignes();
	}
}