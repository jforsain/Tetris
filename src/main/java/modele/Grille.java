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
				s += "?";
			}
			 s += "\n";
		}
		
		return s;
	}
	

	public boolean blocsTombant() {
		return false;
	}

	public int[][] getiLaGrilleTab() {
		return iLaGrilleTab;
	}

	public void setiLaGrilleTab(int iLaGrilleTab[][]) {
		this.iLaGrilleTab = iLaGrilleTab;
	}
}
