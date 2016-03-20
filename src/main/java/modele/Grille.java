package modele;

public class Grille {

	private int lignes;
	private int colonnes;
	private int la_grille[][];
	
	public Grille(int pLignes, int pColonnes) {
		super();
		this.lignes = pLignes;
		this.colonnes = pColonnes;
		this.la_grille = new int[pLignes][pColonnes];
	}
	
	public String toString()
	{
		String s  = "";
		for (int i = 0; i < lignes; i++) {
			for (int j = 0; j < colonnes; j++) {
				s += "?";
			}
			 s += "\n";
		}
		
		return s;
	}
	

	public boolean blocsTombant() {
		return false;
	}

	public int[][] get_la_grille() {
		return la_grille;
	}

	public void set_la_grille(int la_grille[][]) {
		this.la_grille = la_grille;
	}
}
