package vue;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

import modele.TetrisModele;

public class ScorePanel extends JPanel {
	
	private JLabel score;
	private TetrisModele tetrisModele;
	
	public ScorePanel(TetrisModele pTerisModele)
	{
		this.tetrisModele = pTerisModele;
		
		this.score = new JLabel("Score : " + Integer.toString(tetrisModele.getJeu().getScore()));

		score.setFont(new Font ("Serif", Font.PLAIN, 50));
		
		/* On ajoute nos composants dans notre JPanel */
		this.add(this.score);
	}
	
	public void updateScore(){
		if (tetrisModele.getJeu().getScore() % 1000 == 0 && tetrisModele.getJeu().getScore() != 0 && tetrisModele.getJeu().getModeJeu() != 1)
			score.setText("<html>Score : " + Integer.toString(tetrisModele.getJeu().getScore())+ "<br>Malus envoyé!</html>");
		else
			score.setText("Score : " + Integer.toString(tetrisModele.getJeu().getScore()));
			
			
	}
}
