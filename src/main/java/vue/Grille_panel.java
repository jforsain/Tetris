package vue;

import java.awt.Graphics;
import javax.swing.JPanel;
import modele.Grille;

public class Grille_panel extends JPanel { 
	private Grille grille_courante ;
	
	public Grille_panel (Grille pGrille){
		this.grille_courante= pGrille;
	}
	
	  public void paintComponent(Graphics g){
		
		  int inb_lignes = grille_courante.getiLignes();
		  int inb_colonnes = grille_courante.getiColonnes();
		  int la_grille[][] = grille_courante.getiLaGrilleTab();
		  int larg = this.getWidth();
		  int haut = this.getHeight();
		  System.out.println(inb_lignes);
		  System.out.println(inb_colonnes);
		  for (int k = 0; k <inb_lignes;k++){
			  for (int l = 0; l < inb_colonnes;l++){
				  	
				  System.out.print(la_grille[k][l]);  
			  }
			  System.out.println();
		  }
		  
		  for (int i=0;i<inb_lignes;i++){
		    g.drawLine(i*larg/inb_colonnes, 0, i*larg/inb_colonnes, haut);
		  }
		  for (int j=0;j<inb_lignes;j++){
			    g.drawLine(0, j*haut/inb_lignes, larg, j*haut/inb_lignes);
		  }
		  
		  for (int i = 0;i<inb_lignes;i++){
				for (int j=0;j<inb_colonnes;j++){
					if (la_grille[i][j]==1){
					//g.draw3DRect(i*haut/inb_lignes, i*larg/inb_colonnes, larg/inb_colonnes, haut/inb_lignes, true);
					g.draw3DRect(j*larg/inb_colonnes, i*haut/inb_lignes, larg/inb_colonnes, haut/inb_lignes,true);
					g.fill3DRect(j*larg/inb_colonnes, i*haut/inb_lignes, larg/inb_colonnes, haut/inb_lignes,true);
					}				
				}
			}
		  
	  }               
}