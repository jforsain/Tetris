package modele;

public class Jeu {
	
	private int lignesCompletees;
	private int score;
	private boolean enPause;
	private boolean jeuFini;
	private Piece pieceSuivante;
	private int niveau;
	private int temps_descente;
	
	public Jeu() {
		this.jeuFini = true;
		this.score = 0;
		this.lignesCompletees = 0;
		this.niveau = 1;
		this.temps_descente = 1000;
	}
	
	public int getLignesCompletees() {
		return lignesCompletees;
	}

	public void setLignesCompletees(int lignesCompletees) {
		this.lignesCompletees = lignesCompletees;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public boolean isEnPause() {
		return enPause;
	}

	public void setEnPause(boolean enPause) {
		this.enPause = enPause;
	}

	public boolean isJeuFini() {
		return jeuFini;
	}

	public void setJeuFini(boolean jeuFini) {
		this.jeuFini = jeuFini;
	}

	public Piece getPieceSuivante() {
		return pieceSuivante;
	}

	public void setPieceSuivante(Piece pieceSuivante) {
		this.pieceSuivante = pieceSuivante;
	}

	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	public int getTemps_descente() {
		return temps_descente;
	}

	public void setTemps_descente(int temps_descente) {
		this.temps_descente = temps_descente;
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
