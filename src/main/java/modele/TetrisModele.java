package modele;

import java.util.Observable;

public class TetrisModele extends Observable {

	private Grille grille;
	private Jeu jeu;
	private Piece piece;
	private Piece pieceSuivante;
	MeilleursScoresDAO meilleursScoresDAO;

	public TetrisModele() {
		this.jeu = new Jeu();
		this.grille = new Grille(20, 10);
		this.meilleursScoresDAO = new MeilleursScoresDAO();
	}
	
	public Grille getGrille() {
		return this.grille;
	}

	public void setGrille(int pLignes, int pColonnes) {
		this.grille = new Grille(pLignes, pColonnes);
	}
	
	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public Piece getPieceSuivante() {
		return pieceSuivante;
	}

	public void setPieceSuivante(Piece pieceSuivante) {
		this.pieceSuivante = pieceSuivante;
	}
	
	public Jeu getJeu() {
		return jeu;
	}
}
