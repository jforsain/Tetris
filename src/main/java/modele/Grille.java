package modele;

import java.util.Observable;

public class Grille extends Observable {

	private int iLignes;
	private int iColonnes;
	private int iLaGrilleTab[][];
	private Piece pieceCourante;
	private int deltaX;
	private int deltaY;
	
	public Grille(int pLignes, int pColonnes) {
		super();
		this.iLignes = pLignes+1;
		this.iColonnes = pColonnes+2;
		this.iLaGrilleTab = new int[iLignes][iColonnes];
		this.deltaX = 0;
		this.deltaY = 0;
		initialisationGrille();
	}
	
	private void initialisationGrille()
	{
		for(int i = 0; i < this.iLignes; i++)
		{
			for(int j = 0; j < this.iColonnes; j++)
			{	
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

	public void apparition_piece(Piece p){
		Coordonnees coord[][] = p.getCoordonnees();
		int iPosition = p.getiPosition();
		deltaX = 0;
		deltaY = (int) ((iColonnes-2) / 2) - 2;
		
		for (int i = 0;i<=3;i++){
			int x = coord[iPosition-1][i].getX();
			x = x + deltaX;
			int y = coord[iPosition-1][i].getY();
			y = y + deltaY;

			iLaGrilleTab[x][y]= 1;
		}
	}
	
	public void descendre_piece(Piece p){
		vider_piece_dans_grille(p);
		Coordonnees coord[][] = p.getCoordonnees();
		int iPosition = p.getiPosition();
		deltaX++;
		for (int i = 0;i<=3;i++){
			int x = coord[iPosition-1][i].getX();
			x = x + deltaX;
			int y = coord[iPosition-1][i].getY();
			y = y + deltaY;

			iLaGrilleTab[x][y]= 1;
			setChanged();
			notifyObservers();
		}
	}
	
	public void decaler_droite(Piece p) {
		vider_piece_dans_grille(p);
		Coordonnees coord[][] = p.getCoordonnees();
		int iPosition = p.getiPosition();
		deltaY++;
		for (int i = 0;i<=3;i++){
			int x = coord[iPosition-1][i].getX();
			x = x + deltaX;
			int y = coord[iPosition-1][i].getY();
			y = y + deltaY;

			iLaGrilleTab[x][y]= 1;
			setChanged();
			notifyObservers();
		}
	}
	
	public void decaler_gauche(Piece p) {
		vider_piece_dans_grille(p);
		Coordonnees coord[][] = p.getCoordonnees();
		int iPosition = p.getiPosition();
		deltaY--;
		for (int i = 0;i<=3;i++){
			int x = coord[iPosition-1][i].getX();
			x = x + deltaX;
			int y = coord[iPosition-1][i].getY();
			y = y + deltaY;

			iLaGrilleTab[x][y]= 1;
			setChanged();
			notifyObservers();
		}
	}
	
	public void vider_piece_dans_grille(Piece p) {
		Coordonnees coord[][] = p.getCoordonnees();
		int iPosition = p.getiPosition();
		for (int i = 0;i<=3;i++){
			int x = coord[iPosition-1][i].getX();
			x = x + deltaX;
			int y = coord[iPosition-1][i].getY();
			y = y + deltaY;

			iLaGrilleTab[x][y]= 0;
			setChanged();
			notifyObservers();
		}
	}
	
	public Boolean peut_descendre (Piece p){
		
		vider_piece_dans_grille(p);
		Boolean libre = true;
		Coordonnees coord[][] = p.getCoordonnees();
		int iPosition = p.getiPosition();
		for (int i = 0;i<=3;i++){
			int x = coord[iPosition-1][i].getX();
			x = x + deltaX;
			int y = coord[iPosition-1][i].getY();
			y = y + deltaY;

			if (iLaGrilleTab[x+1][y] == 1)
				libre = false;

		}
		
		return libre;
	}
	
	public void poser_piece(Piece p){
		Coordonnees coord[][] = p.getCoordonnees();
		int iPosition = p.getiPosition();
		for (int i = 0;i<=3;i++){
			int x = coord[iPosition-1][i].getX();
			x = x + deltaX;
			int y = coord[iPosition-1][i].getY();
			y = y + deltaY;

			iLaGrilleTab[x][y]= 1;
			setChanged();
			notifyObservers();
		}
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
	
	public int getDeltaX() {
		return deltaX;
	}

	public void setDeltaX(int deltaX) {
		this.deltaX = deltaX;
	}

	public int getDeltaY() {
		return deltaY;
	}

	public void setDeltaY(int deltaY) {
		this.deltaY = deltaY;
	}
	
}
