package vue;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

import modele.TetrisModele;

public class ScoreAdversairePanel extends JPanel {
	
	private JLabel scoreAdversaire;
	private TetrisModele tetrisModele;
	
	public ScoreAdversairePanel(TetrisModele terisModele)
	{
		this.tetrisModele = terisModele;
		
		this.scoreAdversaire = new JLabel("<html>Score ennemi :<br>" + Integer.toString(tetrisModele.getJeu().getScoreAdversaire())+ " </html>");

		scoreAdversaire.setFont(new Font ("Serif", Font.PLAIN, 50));
		
		/* On ajoute nos composants dans notre JPanel */
		this.add(this.scoreAdversaire);
	}
	
	public void updateScoreAdversaire(){
		if (tetrisModele.getJeu().getScoreAdversaire() % 1000!=0 || tetrisModele.getJeu().getScoreAdversaire() == 0)
			scoreAdversaire.setText("<html>Score adversaire :<br>" + Integer.toString(tetrisModele.getJeu().getScoreAdversaire())+ " </html>");
		else
			scoreAdversaire.setText("<html>Score adversaire :<br>" + Integer.toString(tetrisModele.getJeu().getScoreAdversaire())+ " Malus reçu!</html>");
	}	
}
