package vue;

import javax.swing.JLabel;
import javax.swing.JPanel;

import modele.TetrisModele;

public class ScorePanel extends JPanel {
	
	private JLabel scoreLabel;
	private JLabel score;
	private TetrisModele tetrisModele;
	
	public ScorePanel(TetrisModele pTterisModele)
	{
		this.tetrisModele = pTterisModele;
		
		this.score = new JLabel("0");
		this.scoreLabel = new JLabel("Score");
		
		/* On ajoute nos composants dans notre JPanel */
		this.add(this.scoreLabel, "Center");
	}
}
