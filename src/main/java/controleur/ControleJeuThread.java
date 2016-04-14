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
			if (tetrisModele.getGrille().peutDescendre(tetrisModele.getPiece())){
				tetrisModele.getGrille().descendrePiece(tetrisModele.getPiece());
				scoreAdversaire = tetrisModele.getJeu().getScoreAdversaire();
				verifMalus();
			}
			
			else {
				tetrisModele.getGrille().poserPiece(tetrisModele.getPiece());
				nbLignesCompletees = tetrisModele.getGrille().ligneCompletee();
				tetrisModele.getJeu().setScore(tetrisModele.getJeu().getScore()+(100*nbLignesCompletees));
				tetrisModele.getJeu().setLignesCompletees((tetrisModele.getJeu().getLignesCompletees()+nbLignesCompletees));
				piece = tetrisModele.getPieceSuivante();

				if (tetrisModele.getGrille().peutApparaitre(piece)) {
					tetrisModele.getGrille().apparitionPiece(piece);
					tetrisModele.setPiece(piece);
					pieceSuivante = pf.getPieceRandom();
					tetrisModele.setPieceSuivante(pieceSuivante);
				}
				else {
					tetrisModele.getJeu().setGameOver(true);
					tetrisModele.getJeu().setJeuNonDemarre(true);
					tetrisModele.getGrille().rafraichirGrille(piece);
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
	
	public void malus1(){ // 2 niveaux de plus d'un coup (et 2 acc�l�rations associ�es)
		tetrisModele.getJeu().setTempsDescente ((int) (tetrisModele.getJeu().getTempsDescente()*0.9));
		tetrisModele.getJeu().setTempsDescente ((int) (tetrisModele.getJeu().getTempsDescente()*0.9));
		tetrisModele.getJeu().setNiveau(tetrisModele.getJeu().getNiveau()+2);
	}
	
	public void malus2(){ // 1 ligne de blocs suppl�maire en bas
		tetrisModele.getGrille().lancerMalus2(tetrisModele.getPiece());
	}
	
	public void malus3(){ // L'utilisateur perd le contr�le des touches pendant 5 secondes
		ControleurMalus3Thread controleurMalus3Thread = new ControleurMalus3Thread (tetrisModele);
		controleurMalus3Thread.start();
	}
}
