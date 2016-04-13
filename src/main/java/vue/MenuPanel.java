package vue;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;

import modele.TetrisModele;

public class MenuPanel extends JPanel{
	
	private TetrisModele tetrisModele;
	private JButton onePlayer; 
	private JButton twoPlayers;
	private int[] meilleursScores;
	private Object[][] meilleursScoresObject;
	private String[] titreColonne;
	private JTable top5;
	
	public MenuPanel(TetrisModele tetrisModele)
	{
		this.tetrisModele = tetrisModele;
		
		onePlayer = new JButton("Tapez 'a' pour jouer en solo"); 
		twoPlayers = new JButton("Tapez 'b' pour jouer en multijoueurs");
		
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
		this.add(twoPlayers);
		this.add(top5.getTableHeader());
		this.add(top5 );
		
	}
}
