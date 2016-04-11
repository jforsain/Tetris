package modele;

public class Jeu {
	
	private Grille grille;
	private int lignesCompletees;
	private int score;
	private boolean enPause;
	private boolean jeuFini;
	private Piece pieceSuivante;
	private int niveau;
	private int temps_descente;
	
	public Jeu() {
		this.jeuFini = false;
		this.score = 0;
		this.lignesCompletees = 0;
		this.niveau = 1;
		this.temps_descente = 1000;
	
	}
	
	public int get_temps_descente(){
		return this.temps_descente;
	}
	
	public void set_temps_descente(int temps_descente){
		this.temps_descente = temps_descente;
	}
	
	public int get_niveau(){
		return this.niveau;
	}
	
	public void set_niveau(int niveau){
		this.niveau = niveau;
	}
	
}
