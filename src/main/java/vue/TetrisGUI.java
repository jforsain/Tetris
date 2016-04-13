package vue;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

import modele.Grille;
import modele.TetrisModele;

public class TetrisGUI extends JFrame implements Observer {
	
	/* La vue connait le modèle */
	private TetrisModele tetrisModele;
	
	/* Panels */
	private JSplitPane fullTetrisPanel;
	private MenuPanel menuPanel;
	private GrillePanel grillePanel;
	private StatsPanel statsPanel;
	
	public TetrisGUI(TetrisModele modele) {
		this.tetrisModele = modele; // Liaison Vue - Modele
		
		// Initialisation Panel
		this.menuPanel = new MenuPanel(this.tetrisModele);
		this.grillePanel = new GrillePanel(this.tetrisModele);
		this.statsPanel = new StatsPanel(this.tetrisModele);
		this.fullTetrisPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, this.grillePanel, this.statsPanel);
		
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
		statsPanel.updateStats();
		if (tetrisModele.getJeu().isGameOver())
			goToGameOver();
	}
	
	public void goToGrille()
	{	
		this.getContentPane().removeAll();
		this.add(fullTetrisPanel);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public void goToMenu()
	{		
		this.getContentPane().removeAll();
		this.add(menuPanel);
		this.setVisible(true);
	}

	public void goToGameOver(){
		this.getContentPane().removeAll();
		GameOverPanel gameOverPanel = new GameOverPanel(tetrisModele);
		this.add(gameOverPanel);
		this.setVisible(true);
	}
	
	public StatsPanel getStatsPanel(){
		return this.statsPanel;
	}
}