package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;

import Model.Game;

/**
 * Classe Difficulty permettant au joueur de 
 * choisir la difficulte du jeu 
 */

public class Difficulty {

	/**
	 * attribut public frame correspond a 
	 * une nouvelle fenetre 
	 */
	
	public JFrame frame;

	
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * Create the application.
	 */
	public Difficulty() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * avec les differents niveaux de difficulte e i ou h
	 */
	private void initialize() {
		frame = new JFrame("Choix Difficulte");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		final Difficulty a = this;
		JButton btnNewButton = new JButton("Facile");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Game g;
				try {
					
					g = new Game(true, 'e');
					g.play();
					a.frame.setVisible(false);

				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(134, 11, 145, 44);
		frame.getContentPane().add(btnNewButton);

		JButton button = new JButton("Intermediaire");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Game g;
				try {
					g = new Game(true, 'i');
					g.play();
					a.frame.setVisible(false);

				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(134, 94, 145, 44);
		frame.getContentPane().add(button);

		JButton button_1 = new JButton("Difficile");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Game g;
				try {
					g = new Game(true, 'h');
					g.play();
					a.frame.setVisible(false);

				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_1.setBounds(134, 173, 145, 44);
		frame.getContentPane().add(button_1);
	}
}
