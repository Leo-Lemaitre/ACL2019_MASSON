package View;


import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

import Controler.Controler;


/**
 * @author Horatiu Cirstea, Vincent Thomas
 *
 * interface graphique avec son controller et son afficheur
 *
 */
public class GraphicalInterface  {

	/**
	 * le Panel pour l'afficheur
	 */
	private DrawingPanel panel;
	
	/**
	 * la construction de l'interface graphique: JFrame avec panel pour le game
	 * 
	 * @param gamePainter l'afficheur a utiliser dans le moteur
	 * @param gameController l'afficheur a utiliser dans le moteur
	 * 
	 */ 
	public GraphicalInterface(GamePainter gamePainter,Controler gameController){
		JFrame jframe=new JFrame("JeuMasson");
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//    jframe.setPreferredSize(new Dimension(400, 400));
		// attacher le panel contenant l'afficheur du game
		this.panel=new DrawingPanel(gamePainter);
		jframe.setContentPane(this.panel);
		
		// attacher controller au panel du game
		this.panel.addKeyListener(gameController);	
		this.panel.setBackground(Color.red);
		
		jframe.pack();
		jframe.setVisible(true);
		jframe.getContentPane().setFocusable(true);
		jframe.getContentPane().requestFocus();
	}
	
	/**
	 * mise a jour du dessin
	 */
	public void paint() {
		System.out.println("Méthode paint");
		this.panel.drawGame();	
	}
	
}