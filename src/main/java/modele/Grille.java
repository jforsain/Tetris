package modele;

import java.util.Observable;

public class Grille extends Observable {

	private int iLignes;
	private int iColonnes;
	private int iLaGrilleTab[][];
	private int deltaX;
	private int deltaY;

	public Grille(int pLignes, int pColonnes) {
		super();
		this.iLignes = pLignes + 1;//Une ligne de plus en bas avec des 1 pour faciliter les contr�les
		this.iColonnes = pColonnes + 2; // Deux colonnes de plus � gauche et � droite pour la m�me raison
		this.iLaGrilleTab = new int[iLignes][iColonnes];
		this.deltaX = 0; //le delta � ajouter en X pour placer correctement la pi�ce dans la grille
		this.deltaY = 0; // idem en Y
		initialisationGrille();
	}

	private void initialisationGrille() {
		for (int i = 0; i < this.iLignes; i++) {
			for (int j = 0; j < this.iColonnes; j++) {
				if (i == iLignes - 1)
					iLaGrilleTab[i][j] = 1;
				else {
					if (j == 0 || j == iColonnes - 1)
						this.iLaGrilleTab[i][j] = 1;
					else
						this.iLaGrilleTab[i][j] = 0;
				}
			}
		}

	}

	public boolean peutApparaitre(Piece p){

		deltaX = 0;
		deltaY = (int) ((iColonnes - 2) / 2) - 1;
		boolean libre = true;
		Coordonnees coord[][] = p.getCoordonnees();
		int iPosition = p.getiPosition();
		for (int i = 0; i <= 3; i++) {
			int x = coord[iPosition - 1][i].getX();
			x = x + deltaX;
			int y = coord[iPosition - 1][i].getY();
			y = y + deltaY;
			
			if (iLaGrilleTab[x][y] != 0)
				libre = false;
		}
		return libre;
		
	}
	
	public void apparitionPiece(Piece p) {
		Coordonnees coord[][] = p.getCoordonnees();
		int iPosition = p.getiPosition();
		deltaX = 0;
		deltaY = (int) ((iColonnes - 2) / 2) - 1;

		for (int i = 0; i <= 3; i++) {
			int x = coord[iPosition - 1][i].getX();
			x = x + deltaX;
			int y = coord[iPosition - 1][i].getY();
			y = y + deltaY;

			iLaGrilleTab[x][y] = p.getiCouleur();
			setChanged();
			notifyObservers();
		}

	}

	/* Vérifie si on peut déplacer la pièce en bas */
	public Boolean peutDescendre(Piece p) {

		viderPieceDansGrille(p);
		Boolean libre = true;
		Coordonnees coord[][] = p.getCoordonnees();
		int iPosition = p.getiPosition();
		for (int i = 0; i <= 3; i++) {
			int x = coord[iPosition - 1][i].getX();
			x = x + deltaX;
			int y = coord[iPosition - 1][i].getY();
			y = y + deltaY;

			if (iLaGrilleTab[x + 1][y] != 0)
				libre = false;
		}

		return libre;
	}
	
	
	public void descendrePiece(Piece p) {
		viderPieceDansGrille(p);
		Coordonnees coord[][] = p.getCoordonnees();
		int iPosition = p.getiPosition();
		deltaX++;
		for (int i = 0; i <= 3; i++) {
			int x = coord[iPosition - 1][i].getX();
			x = x + deltaX;
			int y = coord[iPosition - 1][i].getY();
			y = y + deltaY;

			iLaGrilleTab[x][y] = p.getiCouleur();
			setChanged();
			notifyObservers();
		}
	}


	/* Vérifie si on peut déplacer la pièce à droite */
	public Boolean peutAllerDroite(Piece p) {

		viderPieceDansGrille(p);
		Boolean libre = true;
		Coordonnees coord[][] = p.getCoordonnees();
		int iPosition = p.getiPosition();
		for (int i = 0; i <= 3; i++) {
			int x = coord[iPosition - 1][i].getX();
			x = x + deltaX;
			int y = coord[iPosition - 1][i].getY();
			y = y + deltaY;

			if (iLaGrilleTab[x][y + 1] != 0)
				libre = false;
		}
		return libre;
	}


	public void decalerDroite(Piece p) {
		viderPieceDansGrille(p);
		Coordonnees coord[][] = p.getCoordonnees();
		int iPosition = p.getiPosition();
		deltaY++;
		for (int i = 0; i <= 3; i++) {
			int x = coord[iPosition - 1][i].getX();
			x = x + deltaX;
			int y = coord[iPosition - 1][i].getY();
			y = y + deltaY;

			iLaGrilleTab[x][y] = p.getiCouleur();
			setChanged();
			notifyObservers();
		}
	}

	/* Vérifie si on peut déplacer la pièce à gauche */
	public Boolean peutAllerGauche(Piece p) {

		viderPieceDansGrille(p);
		Boolean libre = true;
		Coordonnees coord[][] = p.getCoordonnees();
		int iPosition = p.getiPosition();
		for (int i = 0; i <= 3; i++) {
			int x = coord[iPosition - 1][i].getX();
			x = x + deltaX;
			int y = coord[iPosition - 1][i].getY();
			y = y + deltaY;

			if (iLaGrilleTab[x][y - 1] != 0)
				libre = false;
		}

		return libre;
	}
	
	public void decalerGauche(Piece p) {
		viderPieceDansGrille(p);
		Coordonnees coord[][] = p.getCoordonnees();
		int iPosition = p.getiPosition();
		deltaY--;
		for (int i = 0; i <= 3; i++) {
			int x = coord[iPosition - 1][i].getX();
			x = x + deltaX;
			int y = coord[iPosition - 1][i].getY();
			y = y + deltaY;

			iLaGrilleTab[x][y] = p.getiCouleur();
			setChanged();
			notifyObservers();
		}
	}

	/* Verifie si piece peut pivoter */
	public Boolean peutPivoter(Piece p) {
		boolean libre = true;
		viderPieceDansGrille(p);
		Coordonnees coord[][] = p.getCoordonnees();
		/* On met à jour la position de la piece */
		p.pivoterDroit();
		int iPosition = p.getiPosition();

		for (int i = 0; i <= 3; i++) {
			int x = coord[iPosition - 1][i].getX();
			x = x + deltaX;
			int y = coord[iPosition - 1][i].getY();
			y = y + deltaY;
			if (x > iLignes - 1 || y > iColonnes - 1) {
				libre = false;
			} else if (iLaGrilleTab[x][y] != 0) {
				libre = false;
			}
		}
		if (!libre) {
			p.pivoterGauche();
		}
		rafraichirGrille(p);
		return libre;
	}
	
	public void pivoter(Piece p) {
		viderPieceDansGrille(p);
		Coordonnees coord[][] = p.getCoordonnees();
		p.pivoterDroit();

		int iPosition = p.getiPosition();
		for (int i = 0; i <= 3; i++) {
			int x = coord[iPosition - 1][i].getX();
			x = x + deltaX;
			int y = coord[iPosition - 1][i].getY();
			y = y + deltaY;

			iLaGrilleTab[x][y] = p.getiCouleur();
			setChanged();
			notifyObservers();
		}
	}

	public void viderPieceDansGrille(Piece p) {
		// On récupère les coordonnées de la pièce
		Coordonnees coord[][] = p.getCoordonnees();
		int iPosition = p.getiPosition();

		//
		for (int i = 0; i <= 3; i++) {
			int x = coord[iPosition - 1][i].getX();
			x = x + deltaX;
			int y = coord[iPosition - 1][i].getY();
			y = y + deltaY;

			iLaGrilleTab[x][y] = 0;
		}
	}

	


	public void rafraichirGrille(Piece p) {
		Coordonnees coord[][] = p.getCoordonnees();
		int iPosition = p.getiPosition();
		for (int i = 0; i <= 3; i++) {
			int x = coord[iPosition - 1][i].getX();
			x = x + deltaX;
			int y = coord[iPosition - 1][i].getY();
			y = y + deltaY;

			iLaGrilleTab[x][y] = p.getiCouleur();
			setChanged();
			notifyObservers();
		}
	}

	/**
	 * la méthode poser_piece permet de mettre a jour la grille quand
	 * l'utilisateur a terminé de poser une pièce
	 * 
	 * @parms p
	 * */
	public void poserPiece(Piece p) {
		Coordonnees coord[][] = p.getCoordonnees();
		int iPosition = p.getiPosition();
		for (int i = 0; i <= 3; i++) {
			int x = coord[iPosition - 1][i].getX();
			x = x + deltaX;
			int y = coord[iPosition - 1][i].getY();
			y = y + deltaY;

			iLaGrilleTab[x][y] = p.getiCouleur();
			setChanged();
			notifyObservers();
		}
	}

	public int ligneCompletee() {
		boolean contientBlocs = true;
		int k = 0;
		int[] tableau = new int[10];
		int i = this.iLignes - 2;
		int nbLignesCompletees = 0;
		/* 1 - On stocke chaque ligne dans un tableau */
		while(i >= 0) { // On parcours la
																// grille de bas
																// en haut
			contientBlocs = true;
			for (int j = 1; j <= this.iColonnes - 2; j++) { // parcours de 1 à 10
				tableau[j - 1] = iLaGrilleTab[i][j];
			}			
			k = 0;
			
			/* 2 - On vérifie si toute la ligne contient des blocs */
			while (contientBlocs && k < this.iColonnes - 2) {
				if (tableau[k] == 0)
					contientBlocs = false;
				k++;
			}
			
			/* 3 - Si la ligne contient que des blocs, elle disparaît */
			if (contientBlocs) {
				nbLignesCompletees++;
				for (int l = 1; l <= this.iColonnes - 2; l++) {
					iLaGrilleTab[i][l] = 0;
				}

				/* 4 - On met à jour la grille */
				for (int j = i; j >= 0; j--) { // On parcourt la grille de bas
												// en haut
					for (int m = 1; m <= this.iColonnes - 2; m++) {
						if (j != 0)
							iLaGrilleTab[j][m] = iLaGrilleTab[j - 1][m];
					}
				}
			}
			if(!contientBlocs)
				i--;
		}
		return nbLignesCompletees;
	}

	
	public void lancerMalus2(Piece p){
		viderPieceDansGrille(p);
		
		for (int i = 1; i <= this.iLignes - 2; i++) { // On parcourt la grille de haut en bas et on monte tout d'un cran
			for (int j = 1; j <= this.iColonnes - 2; j++) {
					iLaGrilleTab[i-1][j] = iLaGrilleTab[i][j]; 
			}
		}
		
		for (int j = 1; j <= this.iColonnes - 2; j++) { // On rajoute une ligne en bas avec un trou au centre
			if (j != 6)
				iLaGrilleTab[this.iLignes-2][j] = 8; 
			else
				iLaGrilleTab[this.iLignes-2][j] = 0; 
		}
		
		rafraichirGrille(p);
	}
	
	public int[][] getiLaGrilleTab() {
		return iLaGrilleTab;
	}

	public int getiLignes() {
		return iLignes;
	}

	public int getiColonnes() {
		return iColonnes;
	}

}
