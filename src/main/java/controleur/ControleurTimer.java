package controleur;

import java.util.Timer;

import vue.TetrisGUI;
import modele.Grille;
import modele.Jeu;
import modele.Piece;
import modele.PieceFactory;
import modele.TetrisModele;

public class ControleurTimer {

	private TetrisModele tetrisModele;
	private TetrisGUI tetrisGUI;

	public ControleurTimer(TetrisModele tetrisModele, TetrisGUI tetrisGUI) {
		this.tetrisModele = tetrisModele;
		this.tetrisGUI = tetrisGUI;
	}

	public void initialiser_jeu() {
		Grille grille = tetrisModele.getGrille();
		grille.addObserver(tetrisGUI);

		PieceFactory pf = new PieceFactory();

		Piece piece = pf.getPieceRandom();
		tetrisModele.setPiece(piece);

		grille.apparition_piece(piece);
		lancer_jeu(grille, piece);

	}

	public void lancer_jeu(Grille grille, Piece piece) {
		PieceFactory pf = new PieceFactory();
//		ControleurClavier clavier = new ControleurClavier(grille, piece);
		Jeu jeu = tetrisModele.getJeu();
		
		jeu.setJeuFini(false);
		
		Accelerer accelerer = new Accelerer(jeu);
		Timer timer = new Timer();
		timer.schedule(accelerer, 0, 30000); // Acceleration toutes les 30
												// secondes

		while (!jeu.isJeuFini()) {
			try {
				Thread.sleep(jeu.get_temps_descente());
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (grille.peut_descendre(piece))
				grille.descendre_piece(piece);
			else {
				grille.poser_piece(piece);
				grille.ligne_completee();
				piece = pf.getPieceRandom();

				if (grille.peut_apparaitre(piece)) {
					grille.apparition_piece(piece);
					this.tetrisModele.setPiece(piece);
				}
				else {
					System.out.println("GAME OVER");
					jeu.setJeuFini(true);
				}
			}
		}
	}
}
