package vue;

import javax.swing.JSplitPane;

import modele.TetrisModele;

public class Grille2JoueursPanel extends JSplitPane{
	
	private Joueur1Panel joueur1Panel;
	private Joueur2Panel joueur2Panel;
	private TetrisModele tetrisModele;
	
	public Grille2JoueursPanel(TetrisModele pTetrisModele)
	{
		this.tetrisModele = pTetrisModele;
		this.joueur1Panel = new Joueur1Panel(this.tetrisModele);
		this.joueur2Panel = new Joueur2Panel(this.tetrisModele);
		
		/* On configure les composnats D et G de notre Panel */
		this.setRightComponent(this.joueur1Panel);
		this.setLeftComponent(this.joueur2Panel);
	}
}
