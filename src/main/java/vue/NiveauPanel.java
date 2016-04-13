package vue;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import modele.TetrisModele;

public class NiveauPanel extends JPanel {

	private JLabel niveau;
	private TetrisModele tetrisModele;

	public NiveauPanel(TetrisModele pTetrisModele)
	{
		this.tetrisModele = pTetrisModele;
		this.niveau= new JLabel("Niveau : " + Integer.toString(tetrisModele.getJeu().getNiveau()));
		niveau.setFont(new Font ("Serif", Font.PLAIN, 50));

		/* On ajoute nos composants dans notre JPanel */
		this.add(this.niveau);
		
	}
	
	public void updateNiveau(){
		niveau.setText("Niveau : " + Integer.toString(tetrisModele.getJeu().getNiveau()));
	}
}
