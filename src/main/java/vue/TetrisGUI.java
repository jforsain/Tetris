package vue;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

import modele.Grille;
import modele.TetrisModele;

public class TetrisGUI extends JFrame implements Observer {
	
	/* La vue connait le modèle */
	private TetrisModele tetrisModele;
	
	private Grille grille_courante;
	
	/* Panels */
	private JSplitPane fullTetrisPanel;
	private MenuPanel menuPanel = new MenuPanel();
	private GrillePanel grillePanel;
	private StatsPanel statsPanel;
	
	public TetrisGUI(TetrisModele modele) {
		this.tetrisModele = modele; // Liaison Vue - Modele
		
		// Initialisation Panels
		this.grillePanel = new GrillePanel(pGrille);
		this.statsPanel = new StatsPanel();
		this.fullTetrisPanel = new JSplitPane(JSplitPane.VERTICAL_SPLIT, this.grillePanel, this.statsPanel);
		
		/* Paramétrage JFrame */
		this.setTitle("TETRIS");
		this.setSize(400, 800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(menuPanel);
		this.setVisible(true);
	}
	
	public void update(Observable obs, Object obj) {

		repaint();
	}
	
	public void InitialiserGrillePanel ()
	{

		this.grille_courante = tetrisModele.getGrille();
		this.grillePanel = new GrillePanel(grille_courante);
		
	}
	
	public void goToGrille()
	{	
		this.getContentPane().removeAll();
		this.add(grillePanel);
		this.setVisible(true);
	}
	
	public void goToMenu()
	{		
		this.removeAll();
		this.setContentPane(menuPanel);
	}
}