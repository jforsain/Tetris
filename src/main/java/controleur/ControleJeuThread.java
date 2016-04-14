package controleur;

import modele.TetrisModele;
import modele.Piece;
import modele.PieceFactory;

public class ControleJeuThread extends Thread{
	
	private TetrisModele tetrisModele;
	private int scoreAdversaire;
	private int scoreAdversairePrecedent;
	private Piece piece;
	private Piece pieceSuivante;
	private int tempsSave;

	public ControleJeuThread (TetrisModele tetrisModele)
	{
		this.tetrisModele = tetrisModele;
		this.scoreAdversaire = 0;
		this.scoreAdversairePrecedent = 0;

	}
	
	@Override
	public void run ()
	{
		while (!tetrisModele.getJeu().isGameOver())
		{
			PieceFactory pf = new PieceFactory();
			int nbLignesCompletees = 0;
			try {
				Thread.sleep(tetrisModele.getJeu().getTempsDescente());
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (tetrisModele.getGrille().peut_descendre(tetrisModele.getPiece())){
				tetrisModele.getGrille().descendre_piece(tetrisModele.getPiece());
				scoreAdversaire = tetrisModele.getJeu().getScoreAdversaire();
				verifMalus();
			}
			
			else {
				tetrisModele.getGrille().poser_piece(tetrisModele.getPiece());
				nbLignesCompletees = tetrisModele.getGrille().ligne_completee();
				tetrisModele.getJeu().setScore(tetrisModele.getJeu().getScore()+(100*nbLignesCompletees));
				tetrisModele.getJeu().setLignesCompletees((tetrisModele.getJeu().getLignesCompletees()+nbLignesCompletees));
				piece = tetrisModele.getPieceSuivante();

				if (tetrisModele.getGrille().peut_apparaitre(piece)) {
					tetrisModele.getGrille().apparition_piece(piece);
					tetrisModele.setPiece(piece);
					pieceSuivante = pf.getPieceRandom();
					tetrisModele.setPieceSuivante(pieceSuivante);
				}
				else {
					tetrisModele.getJeu().setGameOver(true);
					tetrisModele.getJeu().setJeuNonDemarre(true);
					tetrisModele.getGrille().rafraichir_grille(piece);
					tetrisModele.getMeilleursScoresDAO().nouveauScore(tetrisModele.getJeu().getScore());
				}
			}
		}	
	}
	
	public void verifMalus(){
		if (scoreAdversaire != scoreAdversairePrecedent && scoreAdversaire % 1000 == 0){
			int malusAleatoire = 1 + (int)(Math.random() * ((3 - 1) + 1));
			scoreAdversairePrecedent = scoreAdversaire;
			
			switch (malusAleatoire) {
			case 1:
				malus1();
				break;
				
			case 2:
				malus2();
				break;
				
			case 3:
				malus3();
				break;
				
			}
			
		}
		
	}
	
	public void malus1(){ // 2 niveaux de plus d'un coup (et 2 accélérations associées)
		tetrisModele.getJeu().setTempsDescente ((int) (tetrisModele.getJeu().getTempsDescente()*0.9));
		tetrisModele.getJeu().setTempsDescente ((int) (tetrisModele.getJeu().getTempsDescente()*0.9));
		tetrisModele.getJeu().setNiveau(tetrisModele.getJeu().getNiveau()+2);
	}
	
	public void malus2(){ // 1 ligne de blocs supplémaire en bas
		tetrisModele.getGrille().lancerMalus2(tetrisModele.getPiece());
	}
	
	public void malus3(){ // L'utilisateur perd le contrôle des touches pendant 5 secondes
		ControleurMalus3Thread controleurMalus3Thread = new ControleurMalus3Thread (tetrisModele);
		controleurMalus3Thread.start();
	}
}
