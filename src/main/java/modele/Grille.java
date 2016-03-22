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
		int pos_piece[] = p.getiLaPieceTab();
		int cpt = 0;
		for (int i = 0;i<=3;i++){
			for (int j=3;j<=6;j++){
				iLaGrilleTab[i][j]= pos_piece [cpt];
				cpt++;
			}
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
