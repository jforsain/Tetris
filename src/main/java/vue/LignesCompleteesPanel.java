package vue;

import javax.swing.JLabel;
import javax.swing.JPanel;

import modele.TetrisModele;

public class LignesCompleteesPanel extends JPanel{
	
	private JLabel lignesCompleteesLabel;
	private TetrisModele tetrisModele;
	
	public LignesCompleteesPanel(TetrisModele pTetrisModele)
	{
		this.lignesCompleteesLabel = new JLabel("Lignes");
		this.tetrisModele = pTetrisModele;
		
		/* On ajoute nos composants dans notre JPanel */
		this.add(this.lignesCompleteesLabel, "Center");
	}
}
