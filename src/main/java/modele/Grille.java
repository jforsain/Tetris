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
		this.iLignes = pLignes;
		this.iColonnes = pColonnes;
		this.iLaGrilleTab = new int[pLignes][pColonnes];
		this.deltaX = 0;
		this.deltaY = (int) (pColonnes / 2) - 2;
		initialisationGrille();
	}
	
	private void initialisationGrille()
	{
		for(int i = 0; i < this.iLignes; i++)
		{
			for(int j = 0; j < this.iColonnes; j++)
			{
				this.iLaGrilleTab[i][j] = 0;
			}
		}
	}

	public void apparition_piece(Piece p){
		Coordonnees coord[][] = p.getCoordonnees();
		int iPosition = p.getiPosition();
		
		for (int i = 0;i<=3;i++){
			int x = coord[iPosition-1][i].getX();
			x = x + deltaX;
			int y = coord[iPosition-1][i].getY();
			y = y + deltaY;

			iLaGrilleTab[x][y]= 1;
		}
		
		setChanged();
		notifyObservers();
	}
	
	public void descendre_piece(Piece p){
		Coordonnees coord[][] = p.getCoordonnees();
		int iPosition = p.getiPosition();
		deltaX++;
		for (int i = 0;i<=3;i++){
			int x = coord[iPosition-1][i].getX();
			x = x + deltaX;
			int y = coord[iPosition-1][i].getY();
			y = y + deltaY;

			iLaGrilleTab[x][y]= 1;
		}
		
		setChanged();
		notifyObservers();
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
