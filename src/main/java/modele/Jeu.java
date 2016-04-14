package modele;

public class Jeu {
	
	private int modeJeu;
	private int lignesCompletees;
	private int score;
	private int scoreAdversaire;
	private boolean gameOver;
	private boolean gameOverAdversaire;
	private boolean jeuNonDemarre;
	private Piece pieceSuivante;
	private int niveau;
	private int tempsDescente;
	private boolean malus3EnCours;

	public Jeu() {
		this.modeJeu = 1;
		this.jeuNonDemarre = true;
		this.gameOver = false;
		this.gameOverAdversaire = false;
		this.score = 0;
		this.scoreAdversaire = 0;
		this.lignesCompletees = 0;
		this.niveau = 1;
		this.tempsDescente = 1000;
		this.malus3EnCours = false;

	}
	

	public boolean isGameOverAdversaire() {
		return gameOverAdversaire;
	}


	public void setGameOverAdversaire(boolean gameOverAdversaire) {
		this.gameOverAdversaire = gameOverAdversaire;
	}


	public boolean isMalus3EnCours() {
		return malus3EnCours;
	}

	public void setMalus3EnCours(boolean malus3EnCours) {
		this.malus3EnCours = malus3EnCours;
	}

	public int getLignesCompletees() {
		return lignesCompletees;
	}

	public void setLignesCompletees(int lignesCompletees) {
		this.lignesCompletees = lignesCompletees;
	}

	public int getModeJeu() {
		return modeJeu;
	}

	public void setModeJeu(int modeJeu) {
		this.modeJeu = modeJeu;
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	

	public boolean isGameOver() {
		return gameOver;
	}

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

	public boolean isJeuNonDemarre() {
		return jeuNonDemarre;
	}

	public void setJeuNonDemarre(boolean jeuNonDemarre) {
		this.jeuNonDemarre = jeuNonDemarre;
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

	public int getTempsDescente() {
		return tempsDescente;
	}

	public void setTempsDescente(int temps_descente) {
		this.tempsDescente = temps_descente;
	}
	
	public int getScoreAdversaire() {
		return scoreAdversaire;
	}

	public void setScoreAdversaire(int scoreAdversaire) {
		this.scoreAdversaire = scoreAdversaire;
	}
}