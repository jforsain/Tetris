package controleur;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;

import modele.Grille;
import modele.Jeu;
import modele.Piece;
import modele.PieceFactory;
import modele.TetrisModele;
import vue.TetrisGUI;

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
		Jeu jeu = tetrisModele.getJeu();
		
		jeu.setJeuFini(false);

		final Timer timerAcc = new Timer();
		TimerTask timerTaskAcc = new TimerTask()
			{
				@Override
				public void run() 
				{
					tetrisModele.getJeu().set_temps_descente ((int) (tetrisModele.getJeu().get_temps_descente()*0.9));
					tetrisModele.getJeu().set_niveau (tetrisModele.getJeu().get_niveau() + 1);
				};	
			};
		
		ControleJeuThread controleJeuThread = new ControleJeuThread(tetrisModele);
		controleJeuThread.start();
		
		timerAcc.schedule(timerTaskAcc, 30000, 30000); // Acceleration toutes les 30
												// secondes
	
	}
}
