package vue;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import modele.TetrisModele;

public class GameOverPanel extends JPanel {
	
	private JLabel gameOver;
	private TetrisModele tetrisModele;
	
	public GameOverPanel(TetrisModele pTterisModele)
	{
		this.tetrisModele = pTterisModele;
		
		if (tetrisModele.getJeu().getModeJeu()==1)
			this.gameOver = new JLabel("<html>GAME OVER<br>Score final : " + Integer.toString(tetrisModele.getJeu().getScore()) +
				"<br>Niveau atteint : " + Integer.toString(tetrisModele.getJeu().getNiveau())+ "</html>", SwingConstants.CENTER);
		else if (tetrisModele.getJeu().isGameOverAdversaire())
			this.gameOver = new JLabel("<html>VICTOIRE<br>Votre adverse a tenu moins longtemps<br>Votre Score : " + Integer.toString(tetrisModele.getJeu().getScore()) +
					"<br>Score adversaire : " + Integer.toString(tetrisModele.getJeu().getScoreAdversaire())+ "</html>", SwingConstants.CENTER);
			else
				this.gameOver = new JLabel("<html>DEFAITE<br>Votre adverse a tenu plus longtemps<br>Votre Score : " + Integer.toString(tetrisModele.getJeu().getScore()) +
						"<br>Score en cours adversaire : " + Integer.toString(tetrisModele.getJeu().getScoreAdversaire())+ "</html>", SwingConstants.CENTER);
			
			
		gameOver.setFont(new Font ("Serif", Font.PLAIN, 40));
		
		/* On ajoute nos composants dans notre JPanel */
		this.add(this.gameOver);
	}
	
}
