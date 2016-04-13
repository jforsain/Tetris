package vue;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;

import modele.TetrisModele;

public class MenuPanel extends JPanel{
	
	private JButton onePlayer;
	private JButton twoPlayersServeur;
	private JButton twoPlayersClient;
	private TetrisModele tetrisModele;
	private int[] meilleursScores;
	private Object[][] meilleursScoresObject;
	private String[] titreColonne;
	private JTable top5;
	
	public MenuPanel(TetrisModele tetrisModele)
	{
		this.tetrisModele = tetrisModele;
		
		onePlayer = new JButton("Tapez 'a' pour jouer en solo"); 
		twoPlayersServeur = new JButton("Tapez 'b' pour héberger une partie multijoueurs");
		twoPlayersClient = new JButton("Tapez 'c' pour rejoindre une partie multijoueurs");
		
		meilleursScoresObject = new Object [5][1];
		titreColonne = new String[1];
		meilleursScores = new int[5];
		meilleursScores = tetrisModele.getMeilleursScoresDAO().getMeilleursScores();
				
		for (int i=0; i<5; i++){
			meilleursScoresObject[i][0]= (int) meilleursScores[i];
		}
		
		titreColonne[0]="TOP 5";
		
		top5  = new JTable(meilleursScoresObject, titreColonne);
		
		mettreEnPage();
		
	}
	
	public void mettreEnPage(){
		

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.add(onePlayer);
		this.add(twoPlayersServeur);
		this.add(twoPlayersClient);
		this.add(top5.getTableHeader());
		this.add(top5 );
		
	}
}
