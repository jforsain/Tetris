package vue;

import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import modele.Grille;

public class GrillePanel extends JPanel { 
	private Grille grille_courante ;
	
	public GrillePanel (Grille pGrille){
		this.grille_courante= pGrille;
		
//		System.out.println("testmat");
//		for (int i = 0; i<21; i++)
//		{
//			for (int j=0 ; j<12; j++)
//			{
//				System.out.print(grille_courante.getiLaGrilleTab()[i][j]);
//			}
//			System.out.println("");
//		}
		
	}
	
	  public void paint(Graphics g){

		  int inb_lignes = grille_courante.getiLignes();
		  int inb_colonnes = grille_courante.getiColonnes();
		  int la_grille[][] = grille_courante.getiLaGrilleTab();
		  int larg = this.getWidth();
		  int haut = this.getHeight();
		
		  for (int i=0;i<=inb_lignes-1;i++){
			  g.drawLine(0, i*haut/(inb_lignes-1), larg, i*haut/(inb_lignes-1));
		  }
		  for (int j=0;j<=inb_colonnes-2;j++){
			  g.drawLine(j*larg/(inb_colonnes-2), 0, j*larg/(inb_colonnes-2), haut);
		  }
		  
		  for (int i = 0;i<inb_lignes-1;i++){
				for (int j=0;j<inb_colonnes-2;j++){
					if (la_grille[i][j+1]==1){
					//g.draw3DRect(i*haut/inb_lignes, i*larg/inb_colonnes, larg/inb_colonnes, haut/inb_lignes, true);
					g.draw3DRect(j*larg/(inb_colonnes-2), i*haut/(inb_lignes-1), larg/(inb_colonnes-2), haut/(inb_lignes-1),false);
					g.fill3DRect(j*larg/(inb_colonnes-2), i*haut/(inb_lignes-1), larg/(inb_colonnes-2), haut/(inb_lignes-1),false);
					}
				}
			}
		  
	  }
           
	
}