package vue;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import modele.TetrisModele;

public class LignesCompleteesPanel extends JPanel{
	
	private JLabel lignesCompletees;
	private TetrisModele tetrisModele;
	
	public LignesCompleteesPanel(TetrisModele pTetrisModele)
	{
		this.tetrisModele = pTetrisModele;
		this.lignesCompletees = new JLabel("Lignes : " + Integer.toString(tetrisModele.getJeu().getLignesCompletees()));
		
		lignesCompletees.setFont(new Font ("Serif", Font.PLAIN, 50));
		
		/* On ajoute nos composants dans notre JPanel */
		this.add(this.lignesCompletees);

	}
	
	public void updateLignesCompletees(){
		lignesCompletees.setText("Lignes : " + Integer.toString(tetrisModele.getJeu().getLignesCompletees()));
	}
}
