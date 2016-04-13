package vue;

import javax.swing.JLabel;
import javax.swing.JPanel;

import modele.TetrisModele;

public class LignesCompleteesPanel extends JPanel{
	
	private JLabel lignesCompleteesLabel;
	private JLabel lignesCompleteesValue;
	private TetrisModele tetrisModele;
	
	public LignesCompleteesPanel(TetrisModele pTetrisModele)
	{
		this.lignesCompleteesLabel = new JLabel("Lignes");
		this.tetrisModele = pTetrisModele;
		this.lignesCompleteesValue = new JLabel(Integer.toString(tetrisModele.getJeu().getLignesCompletees()));
		
		lignesCompleteesLabel.setLabelFor(lignesCompleteesValue);
		
		/* On ajoute nos composants dans notre JPanel */
		this.add(this.lignesCompleteesLabel);
		this.add(this.lignesCompleteesValue);

	}
	
	public void updateLignesCompletees(){
		lignesCompleteesValue.setText(Integer.toString(tetrisModele.getJeu().getLignesCompletees()));
	}
}
