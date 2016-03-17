package modele;

public class Grille {

	private int lignes;
	private int colonnes;
	
	public Grille(int pLignes, int pColonnes) {
		super();
		this.lignes = pLignes;
		this.colonnes = pColonnes;
	}
	
	public String toString()
	{
		String s  = "";
		for (int i = 0; i < lignes; i++) {
			for (int j = 0; j < colonnes; j++) {
				s += ".";
			}
			 s += "\n";
		}
		
		return s;
	}
}
