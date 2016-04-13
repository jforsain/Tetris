package vue;

import javax.swing.JLabel;
import javax.swing.JPanel;

import modele.TetrisModele;

public class NiveauPanel extends JPanel {

	private JLabel niveauLabel;
	private JLabel niveauValue;
	private TetrisModele tetrisModele;

	public NiveauPanel(TetrisModele pTetrisModele)
	{
		this.tetrisModele = pTetrisModele;
		this.niveauLabel = new JLabel("Niveau");
		this.niveauValue = new JLabel(Integer.toString(tetrisModele.getJeu().getNiveau()));
		
		/* On ajoute nos composants dans notre JPanel */
		this.add(this.niveauLabel);
		this.add(this.niveauValue);
		
	}
	
	public void updateNiveau(){
		niveauValue.setText(Integer.toString(tetrisModele.getJeu().getNiveau()));
	}
}
