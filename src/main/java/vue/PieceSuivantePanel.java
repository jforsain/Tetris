package vue;

import javax.swing.JLabel;
import javax.swing.JPanel;

import modele.TetrisModele;

public class PieceSuivantePanel extends JPanel{
	
	private TetrisModele tetrisModele;
	private JLabel pieceSuivanteLabel;
	
	public PieceSuivantePanel(TetrisModele pTetrisModele)
	{
		this.tetrisModele = pTetrisModele;
		
		this.pieceSuivanteLabel = new JLabel("Piece suivante");
		
		/* On ajoute nos composants dans notre JPanel */
		this.add(this.pieceSuivanteLabel);
	}
}
