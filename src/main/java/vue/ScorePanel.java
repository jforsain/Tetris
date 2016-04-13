package vue;

import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

import modele.TetrisModele;

public class ScorePanel extends JPanel {
	
	private JLabel scoreLabel;
	private JLabel scoreValue;
	private TetrisModele tetrisModele;
	
	public ScorePanel(TetrisModele pTterisModele)
	{
		this.tetrisModele = pTterisModele;
		
		this.scoreValue = new JLabel(Integer.toString(tetrisModele.getJeu().getScore()));
		this.scoreLabel = new JLabel("Score");
		
		/* On ajoute nos composants dans notre JPanel */
		this.add(this.scoreLabel);
		this.add(this.scoreValue);
	}
	
	public void updateScore(){
		scoreValue.setText(Integer.toString(tetrisModele.getJeu().getScore()));
	}
}
