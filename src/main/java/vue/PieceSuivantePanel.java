package vue;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

import modele.Coordonnees;
import modele.Piece;
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
	
	public void paint(Graphics g) {

		Piece pieceSuivante = tetrisModele.getPieceSuivante();
		
		Coordonnees coord[][] = pieceSuivante.getCoordonnees();
		int iPosition = pieceSuivante.getiPosition();
		int iCouleur;
		
		int larg = this.getWidth()-200;
		int haut = this.getHeight();

		for (int i = 0; i <= 5 - 1; i++) {
			g.drawLine(0, i * haut / (5 - 1), larg, i * haut
					/ (5 - 1));
		}
		for (int j = 0; j <= 6 - 2; j++) {
			g.drawLine(j * larg / (6 - 2), 0, j * larg
					/ (6 - 2), haut);
		}

		

		for (int i = 0; i <= 3; i++) {
			int x = coord[iPosition - 1][i].getX();
			int y = coord[iPosition - 1][i].getY();
			
			iCouleur = pieceSuivante.getiCouleur();
			
			switch (iCouleur) {
			case 0:
				g.setColor(Color.white);
				// g.draw3DRect(j*larg/(inb_colonnes-2),
				// i*haut/(inb_lignes-1), larg/(inb_colonnes-2),
				// haut/(inb_lignes-1),false);
				g.fill3DRect(y * larg / 4, x * haut
						/ 4, larg / 4, haut
						/ 4, true);

				break;

			case 1:
				g.setColor(Color.CYAN);
				// g.draw3DRect(j*larg/(inb_colonnes-2),
				// i*haut/(inb_lignes-1), larg/(inb_colonnes-2),
				// haut/(inb_lignes-1),false);
				g.fill3DRect(y * larg / 4, x * haut
						/ 4, larg / 4, haut
						/ 4, true);
				break;

			case 2:
				g.setColor(Color.BLUE);
				// g.draw3DRect(j*larg/(inb_colonnes-2),
				// i*haut/(inb_lignes-1), larg/(inb_colonnes-2),
				// haut/(inb_lignes-1),false);
				g.fill3DRect(y * larg / 4, x * haut
						/ 4, larg / 4, haut
						/ 4, true);
				break;

			case 3:
				g.setColor(Color.ORANGE);
				// g.draw3DRect(j*larg/(inb_colonnes-2),
				// i*haut/(inb_lignes-1), larg/(inb_colonnes-2),
				// haut/(inb_lignes-1),false);
				g.fill3DRect(y * larg / 4, x * haut
						/ 4, larg / 4, haut
						/ 4, true);
				break;

			case 4:
				g.setColor(Color.YELLOW);
				// g.draw3DRect(j*larg/(inb_colonnes-2),
				// i*haut/(inb_lignes-1), larg/(inb_colonnes-2),
				// haut/(inb_lignes-1),false);
				g.fill3DRect(y * larg / 4, x * haut
						/ 4, larg / 4, haut
						/ 4, true);
				break;

			case 5:
				g.setColor(Color.RED);
				// g.draw3DRect(j*larg/(inb_colonnes-2),
				// i*haut/(inb_lignes-1), larg/(inb_colonnes-2),
				// haut/(inb_lignes-1),false);
				g.fill3DRect(y * larg / 4, x * haut
						/ 4, larg / 4, haut
						/ 4, true);
				break;

			case 6:
				g.setColor(Color.PINK);
				// g.draw3DRect(j*larg/(inb_colonnes-2),
				// i*haut/(inb_lignes-1), larg/(inb_colonnes-2),
				// haut/(inb_lignes-1),false);
				g.fill3DRect(y * larg / 4, x * haut
						/ 4, larg / 4, haut
						/ 4, true);
				break;

			case 7:
				g.setColor(Color.GREEN);
				// g.draw3DRect(j*larg/(inb_colonnes-2),
				// i*haut/(inb_lignes-1), larg/(inb_colonnes-2),
				// haut/(inb_lignes-1),false);
				g.fill3DRect(y * larg / 4, x * haut
						/ 4, larg / 4, haut
						/ 4, true);
				break;

			}
			
		}
		
	}
}
