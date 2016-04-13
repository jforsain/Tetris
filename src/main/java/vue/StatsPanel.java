package vue;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JPanel;

import modele.TetrisModele;

public class StatsPanel extends JPanel {
	
	private TetrisModele tetrisModele;
	
	private NiveauPanel niveauPanel;
	private ScorePanel scorePanel;
	private ScoreAdversairePanel scoreAdversairePanel;
	private PieceSuivantePanel pieceSuivantePanel;
	private LignesCompleteesPanel lignesCompleteesPanel;
	private GameOverPanel gameOverPanel;
	
	public StatsPanel(TetrisModele pTetrisModele)
	{
		this.tetrisModele = pTetrisModele;
		
		/* On initialise nos composants */
		this.niveauPanel = new NiveauPanel(tetrisModele);
		this.scorePanel = new ScorePanel(tetrisModele);
		this.scoreAdversairePanel = new ScoreAdversairePanel(tetrisModele);
		this.pieceSuivantePanel = new PieceSuivantePanel(tetrisModele);
		this.lignesCompleteesPanel = new LignesCompleteesPanel(tetrisModele);

	}
	
	public void layoutModeJeu(){
		if (tetrisModele.getJeu().getModeJeu()==1){
			/* On précise le gestionnaire de placement de notre composant */
			this.setLayout(new GridLayout(4, 1));		
			/* On ajoute nos composants */
			this.add(this.scorePanel);
			this.add(this.niveauPanel);
			this.add(this.lignesCompleteesPanel);
			this.add(this.pieceSuivantePanel);
		}
		else {
			// On précise le gestionnaire de placement de notre composant
			this.setLayout(new GridLayout(5, 1));		
			// On ajoute nos composants
			this.add(this.scorePanel);
			this.add(this.scoreAdversairePanel);
			this.add(this.niveauPanel);
			this.add(this.lignesCompleteesPanel);
			this.add(this.pieceSuivantePanel);		
		}
	}
	/* On donne des diemnsions à notre composant */
	public int getWidth() {
		return 400;
	}

	public int getHeight() {
		return 800;
	}
	
	public Dimension getPreferredSize()
	{
		return new Dimension(getWidth(), getHeight());
	}
	
	public void updateStats () {
		scorePanel.updateScore();
		niveauPanel.updateNiveau();
		lignesCompleteesPanel.updateLignesCompletees();
		scoreAdversairePanel.updateScoreAdversaire();
	}
	
	
}