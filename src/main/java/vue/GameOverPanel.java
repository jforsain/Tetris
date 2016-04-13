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
		
		this.gameOver = new JLabel("<html>GAME OVER<br>Score final : " + Integer.toString(tetrisModele.getJeu().getScore()) +
				"<br>Niveau atteint : " + Integer.toString(tetrisModele.getJeu().getNiveau())+ "<br><br>Tapez 'z' pour revenir au menu</html>", SwingConstants.CENTER);
		
		gameOver.setFont(new Font ("Serif", Font.PLAIN, 40));
		
		/* On ajoute nos composants dans notre JPanel */
		this.add(this.gameOver);
	}
	
}
