package vue;

import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import modele.Grille;

public class Grille_panel extends JPanel { 
	private Grille grille_courante ;
	
	public Grille_panel (Grille pGrille){
		this.grille_courante= pGrille;
	}
	
	  public void paint(Graphics g){
		
		  int inb_lignes = grille_courante.getiLignes();
		  int inb_colonnes = grille_courante.getiColonnes();
		  int la_grille[][] = grille_courante.getiLaGrilleTab();
		  int larg = this.getWidth();
		  int haut = this.getHeight();
		
		  /*
		  for (int i=0;i<=inb_lignes-1;i++){
		    g.drawLine(i*haut/(inb_lignes-1), 0, i*haut/(inb_lignes-1), larg);
		  }
		  for (int j=0;j<=inb_colonnes-1;j++){
			    g.drawLine(0, j*larg/(inb_colonnes-2), haut, j*larg/(inb_colonnes-2));
		  }
		  */
		  for (int i = 0;i<inb_lignes-1;i++){
				for (int j=1;j<inb_colonnes-1;j++){
					if (la_grille[i][j]==1){
					//g.draw3DRect(i*haut/inb_lignes, i*larg/inb_colonnes, larg/inb_colonnes, haut/inb_lignes, true);
					g.draw3DRect(j*larg/inb_colonnes, i*haut/inb_lignes, larg/inb_colonnes, haut/inb_lignes,false);
					g.fill3DRect(j*larg/inb_colonnes, i*haut/inb_lignes, larg/inb_colonnes, haut/inb_lignes,false);
					}
					else {
						g.drawRect(j*larg/inb_colonnes, i*haut/inb_lignes, larg/inb_colonnes, haut/inb_lignes);
					}
				}
			}
		  
	  }
           
	
}