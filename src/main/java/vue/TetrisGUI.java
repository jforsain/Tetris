package vue;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import modele.Grille;

public class TetrisGUI extends JFrame implements Observer {
	private Grille grille_courante;
	private MenuPanel menuPanel = new MenuPanel();
	private GrillePanel grillePanel = new GrillePanel(pGrille);
	
	public TetrisGUI(Grille pGrille) {
		this.grille_courante = pGrille;
		this.setTitle("TETRIS");
		this.setSize(400, 800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.add(new GrillePanel(grille_courante));

	}

	public void update(Observable obs, Object obj) {

		repaint();
	}

}