package modele;

public class Grille {

	private int iLignes;
	private int iColonnes;
	private int iLaGrilleTab[][];
	
	public Grille(int pLignes, int pColonnes) {
		super();
		this.iLignes = pLignes;
		this.iColonnes = pColonnes;
		this.iLaGrilleTab = new int[pLignes][pColonnes];
	}
	
	public String toString()
	{
		String s  = "";
		for (int i = 0; i < iLignes; i++) {
			for (int j = 0; j < iColonnes; j++) {
				s += ".";
			}
			 s += "\n";
		}
		
		return s;
	}
	

	public boolean blocsTombant() {
		return false;
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
	}

	public void descente_piece(Piece p){
		
	}
	
	public int[][] getiLaGrilleTab() {
		return iLaGrilleTab;
	}
	
	public void setiLaGrilleTab(int iLaGrilleTab[][]) {
		this.iLaGrilleTab = iLaGrilleTab;
	}

	public int getiLignes() {
		return iLignes;
	}

	public int getiColonnes() {
		return iColonnes;
	}
	
	
}
