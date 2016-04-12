package modele;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import javax.swing.Timer;

public class TetrisModele extends Observable {

	private Grille grille;
	private Jeu jeu;
	private Piece piece;

	public TetrisModele() {
		
	}

	public boolean getEnCours() {
		return this.enCours;
	}

	public void changeState() {
		setChanged();
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
