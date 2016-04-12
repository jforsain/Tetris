package vue;

import javax.swing.JPanel;

import modele.TetrisModele;

public class StatsPanel extends JPanel {
	
	private TetrisModele tetrisModele;
	
	private NiveauPanel niveauPanel = new NiveauPanel();
	private ScorePanel scorePanel = new ScorePanel();
	private PieceSuivantePanel pieceSuivantePanel = new PieceSuivantePanel();
	private LignesCompleteesPanel lignesCompleteesPanel = new LignesCompleteesPanel();
	
	public StatsPanel(TetrisModele pTetrisModele)
	{
		
	}
}
