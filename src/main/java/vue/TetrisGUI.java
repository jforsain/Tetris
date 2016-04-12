package vue;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import modele.Grille;
import modele.TetrisModele;

public class TetrisGUI extends JFrame implements Observer {
	private TetrisModele tetrisModele;
	private Grille grille_courante;
	private MenuPanel menuPanel = new MenuPanel();
	private GrillePanel grillePanel = new GrillePanel(pGrille);
	
	public TetrisGUI(TetrisModele modele) {
		this.tetrisModele = modele;
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