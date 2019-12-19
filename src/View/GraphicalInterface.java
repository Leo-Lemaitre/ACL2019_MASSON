package View;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import Controler.Controller;

/**
 * @author Horatiu Cirstea, Vincent Thomas
 *
 *         interface graphique avec son controller et son afficheur
 *
 */
public class GraphicalInterface implements Observer {

	/**
	 * le Panel pour l'afficheur
	 */
	private DrawingPanel panel;

	/**
	 * la construction de l'interface graphique: JFrame avec panel pour le game
	 * 
	 * @param gamePainter
	 *            l'afficheur a utiliser dans le moteur
	 * @param gameController
	 *            l'afficheur a utiliser dans le moteur
	 * 
	 */
	public GraphicalInterface(GamePainter gamePainter, Controller gameController) {
		JFrame jframe = new JFrame("JeuMasson");
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setResizable(false);
		
		// attacher le panel contenant l'afficheur du game
		this.panel = new DrawingPanel(gamePainter);
		jframe.setContentPane(this.panel);

		// attacher controller au panel du game
		this.panel.addKeyListener(gameController);
		this.panel.setBackground(Color.red);

		jframe.pack();
		jframe.setVisible(true);
		jframe.getContentPane().setFocusable(true);
		jframe.getContentPane().requestFocus();
	}

	public DrawingPanel getPanel() {
		return panel;
	}

	public void setPanel(DrawingPanel panel) {
		this.panel = panel;
	}

	/**
	 * mise a jour du dessin
	 */
	public void paint() {
		this.panel.drawGame();
	}

	@Override
	public void update(Observable o, Object arg) {
		paint();

	}

}