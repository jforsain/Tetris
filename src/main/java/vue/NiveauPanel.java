package vue;

import javax.swing.JLabel;
import javax.swing.JPanel;

import modele.TetrisModele;

public class NiveauPanel extends JPanel {

	private JLabel niveauLabel;
	private TetrisModele tetrisModele;

	public NiveauPanel(TetrisModele pTetrisModele)
	{
		this.tetrisModele = pTetrisModele;
		this.niveauLabel = new JLabel("Niveau");
		
		/* On ajoute nos composants dans notre JPanel */
		this.add(this.niveauLabel, "Center");
		
	}
}
