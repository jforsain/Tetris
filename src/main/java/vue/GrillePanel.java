package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import modele.Grille;
import modele.TetrisModele;

public class GrillePanel extends JPanel {
	private Grille grille_courante;

	public GrillePanel(TetrisModele tetrisModele) {
		this.grille_courante = tetrisModele.getGrille();
	}
	
	/* On donne des diemnsions à notre composant */
	public int getWidth() {
		return 400;
	}

	public int getHeight() {
		return 800;
	}
	
	public Dimension getPreferredSize()
	{
		return new Dimension(getWidth(), getHeight());
	}

	public void paint(Graphics g) {

		int inb_lignes = grille_courante.getiLignes();
		int inb_colonnes = grille_courante.getiColonnes();
		int la_grille[][] = grille_courante.getiLaGrilleTab();
		int larg = this.getWidth();
		int haut = this.getHeight();

		for (int i = 0; i <= inb_lignes - 1; i++) {
			g.drawLine(0, i * haut / (inb_lignes - 1), larg, i * haut
					/ (inb_lignes - 1));
		}
		for (int j = 0; j <= inb_colonnes - 2; j++) {
			g.drawLine(j * larg / (inb_colonnes - 2), 0, j * larg
					/ (inb_colonnes - 2), haut);
		}

		for (int i = 0; i < inb_lignes - 1; i++) {
			for (int j = 0; j < inb_colonnes - 2; j++) {
				switch (la_grille[i][j + 1]) {
				case 0:
					g.setColor(Color.white);
					g.fill3DRect(j * larg / (inb_colonnes - 2), i * haut
							/ (inb_lignes - 1), larg / (inb_colonnes - 2), haut
							/ (inb_lignes - 1), true);

					break;

				case 1:
					g.setColor(Color.CYAN);
					g.fill3DRect(j * larg / (inb_colonnes - 2), i * haut
							/ (inb_lignes - 1), larg / (inb_colonnes - 2), haut
							/ (inb_lignes - 1), true);

					break;

				case 2:
					g.setColor(Color.BLUE);
					g.fill3DRect(j * larg / (inb_colonnes - 2), i * haut
							/ (inb_lignes - 1), larg / (inb_colonnes - 2), haut
							/ (inb_lignes - 1), true);

					break;

				case 3:
					g.setColor(Color.ORANGE);
					g.fill3DRect(j * larg / (inb_colonnes - 2), i * haut
							/ (inb_lignes - 1), larg / (inb_colonnes - 2), haut
							/ (inb_lignes - 1), true);

					break;

				case 4:
					g.setColor(Color.YELLOW);
					g.fill3DRect(j * larg / (inb_colonnes - 2), i * haut
							/ (inb_lignes - 1), larg / (inb_colonnes - 2), haut
							/ (inb_lignes - 1), true);

					break;

				case 5:
					g.setColor(Color.RED);
					g.fill3DRect(j * larg / (inb_colonnes - 2), i * haut
							/ (inb_lignes - 1), larg / (inb_colonnes - 2), haut
							/ (inb_lignes - 1), true);

					break;

				case 6:
					g.setColor(Color.PINK);
					g.fill3DRect(j * larg / (inb_colonnes - 2), i * haut
							/ (inb_lignes - 1), larg / (inb_colonnes - 2), haut
							/ (inb_lignes - 1), true);

					break;

				case 7:
					g.setColor(Color.GREEN);
					g.fill3DRect(j * larg / (inb_colonnes - 2), i * haut
							/ (inb_lignes - 1), larg / (inb_colonnes - 2), haut
							/ (inb_lignes - 1), true);

					break;
					
				case 8:
					g.setColor(Color.BLACK);
					g.fill3DRect(j * larg / (inb_colonnes - 2), i * haut
							/ (inb_lignes - 1), larg / (inb_colonnes - 2), haut
							/ (inb_lignes - 1), true);

					break;

				}
			}
		}
	}
}