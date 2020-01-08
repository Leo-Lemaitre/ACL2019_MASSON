package View;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import Model.Character;
import Model.Constants;
import Model.ElementLab;
import Model.Labyrinth;
import Model.Wall;

//Enlever le labyrinthe car singleton
public class AffichageGraphiqueLabyrinthe implements GamePainter {

	// public ImageIcon Arbre1 = new ImageIcon("src/images/Arbre1.png");
	// Image imArbre1 = Arbre1.getImage();

	public AffichageGraphiqueLabyrinthe() {

	}

	public void dra(BufferedImage image) {

		Graphics2D g = (Graphics2D) image.getGraphics();
		for (int ligne = 0; ligne < Labyrinth.getInstance().getNbLines(); ligne++) {
			for (int colonne = 0; colonne < Labyrinth.getInstance().getNbColumns(); colonne++) {

				System.out.println(Labyrinth.getInstance().getElementOnSquare(ligne, colonne));
				switch (Labyrinth.getInstance().getElementOnSquare(ligne, colonne).getType()) {
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
		if (image !=null) {
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
		System.out.println("Points de vie du heros : " + Labyrinth.getInstance().getHeros().getLifePoint());
		g.dispose();
		}
	}

	public void drawListElement(ArrayList<? extends ElementLab> list, Graphics2D g) {
		for (ElementLab e : list) {
			drawElement(e, g);
		}
	}

	public void drawElement(ElementLab e, Graphics2D g) {
		String direction = "";
		int decalage = 0;
		if (e instanceof Character) {
			int[] dir = ((Character) e).getDirection();
			if (dir == Constants.UP) {
				direction = "_Up";
			} else if (dir == Constants.DOWN) {
				direction = "_Down";
			} else if (dir == Constants.LEFT) {
				direction = "_Left";
			} else {
				direction = "_Right";
			}
		}
		
		if (e instanceof Wall) {
			decalage=15;
		}
		g.drawImage(new ImageIcon("src/images/" + e.getImageName() + direction + ".png").getImage(),
				e.getPosColonne() * Constants.SIZESQUARE +decalage, e.getPosLigne() * Constants.SIZESQUARE, null);
	}

	@Override
	public int getWidth() {
		return Constants.SIZESQUARE * Labyrinth.getInstance().getNbColumns();
	}

	@Override
	public int getHeight() {
		return Constants.SIZESQUARE * Labyrinth.getInstance().getNbLines();
	}
}