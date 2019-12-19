package View;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import Model.Constants;
import Model.ElementLab;
import Model.Hero;
import Model.Labyrinth;

//Enlever le labyrinthe car singleton
public class AffichageGraphiqueLabyrinthe implements GamePainter {

	private Labyrinth lab;
	// public ImageIcon Arbre1 = new ImageIcon("src/images/Arbre1.png");
	// Image imArbre1 = Arbre1.getImage();

	public AffichageGraphiqueLabyrinthe(Labyrinth labyrinthe) {
		this.lab = labyrinthe;
	}

	public void dra2(BufferedImage image) {

		Graphics2D g = (Graphics2D) image.getGraphics();
		for (int ligne = 0; ligne < lab.getNbLines(); ligne++) {
			for (int colonne = 0; colonne < lab.getNbColumns(); colonne++) {
				switch (lab.getElementOnSquare(ligne, colonne).getType()) {
				case Constants.EMPTY:
					g.setColor(Color.WHITE);
					break;
				case Constants.HERO:
					g.setColor(Color.YELLOW);
					break;
				case Constants.MONSTER:
					g.setColor(Color.BLUE);
					break;
				case Constants.WALL:
					g.setColor(Color.BLACK);
					// g.drawImage(imArbre1,colonne*
					// Constants.tailleCaseLaby-7,ligne *
					// Constants.tailleCaseLaby-30,null);
					break;
				case Constants.TRAP:
					g.setColor(Color.RED);
					break;
				case Constants.HEALER:
					g.setColor(Color.GREEN);
					break;

				case Constants.TREASURE:
					g.setColor(Color.PINK);
					break;
				default:
					System.out.println("Non reconnu");
				}
				g.fillRect(colonne * Constants.SIZESQUARE, ligne * Constants.SIZESQUARE, Constants.SIZESQUARE,
						Constants.SIZESQUARE);

			}
		}
		System.out.println("Points de vie du heros : " + Labyrinth.getInstance().getHeros().getLifePoint());
		g.dispose();
	}

	public void draw(BufferedImage image) {
		Graphics2D g = (Graphics2D) image.getGraphics();

		for (int j = 0; j <= Labyrinth.getInstance().getNbColumns(); j++) {
			for (int i = 0; i <= Labyrinth.getInstance().getNbLines(); i++) {
				g.drawImage(new ImageIcon("src/images/Grass.png").getImage(), j * Constants.SIZESQUARE,
						i * Constants.SIZESQUARE, null);
			}
		}

		drawElement(Labyrinth.getInstance().getHeros(), g);
		drawListElement(Labyrinth.getInstance().getListMonsters(), g);
		drawListElement(Labyrinth.getInstance().getListWalls(), g);

	}

	public void drawListElement(ArrayList<? extends ElementLab> list, Graphics2D g) {
		for (ElementLab e : list) {
			drawElement(e, g);
		}
	}

	public void drawElement(ElementLab e, Graphics2D g) {
		g.drawImage(new ImageIcon("src/images/" + e.getImageName()).getImage(),
				e.getPosColonne() * Constants.SIZESQUARE, e.getPosLigne() * Constants.SIZESQUARE, null);
	}

	@Override
	public int getWidth() {
		return Constants.SIZESQUARE * lab.getNbColumns();
	}

	@Override
	public int getHeight() {
		return Constants.SIZESQUARE * lab.getNbLines();
	}
}