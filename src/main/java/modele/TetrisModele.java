package modele;

import java.util.Observable;

public class TetrisModele extends Observable {

	private Grille grille;
	private Jeu jeu;
	private Piece piece;

	public TetrisModele() {
		this.jeu = new Jeu();
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

	public Jeu getJeu() {
		return jeu;
	}
}
