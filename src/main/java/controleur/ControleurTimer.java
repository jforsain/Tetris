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
	private ControleJeuThread controleJeuThread;
	
	public ControleurTimer(TetrisModele tetrisModele, TetrisGUI tetrisGUI) {
		this.tetrisModele = tetrisModele;
		this.tetrisGUI = tetrisGUI;
	}

	public void initialiser_jeu() {
		Grille grille = tetrisModele.getGrille();
		grille.addObserver(tetrisGUI);
		PieceFactory pf = new PieceFactory();

		Piece piece = pf.getPieceRandom();
		Piece pieceSuivante = pf.getPieceRandom();
		tetrisModele.setPiece(piece);
		tetrisModele.setPieceSuivante(pieceSuivante);

		grille.apparition_piece(piece);
		lancer_jeu();

	}

	public void lancer_jeu() {
		Jeu jeu = tetrisModele.getJeu();
		
		jeu.setJeuNonDemarre(false);

		controleJeuThread = new ControleJeuThread(tetrisModele);
		controleJeuThread.start();
		
		final Timer timerAcceleration = new Timer();
		TimerTask timerTaskAcceleration = new TimerTask()
			{
				@Override
				public void run() 
				{
					tetrisModele.getJeu().setTempsDescente ((int) (tetrisModele.getJeu().getTempsDescente()*0.9));
					tetrisModele.getJeu().setNiveau (tetrisModele.getJeu().getNiveau() + 1);
					
				};	
			};
		
		
		
		timerAcceleration.schedule(timerTaskAcceleration, 30000, 30000); // Acceleration toutes les 30
												// secondes
	
	}
}
