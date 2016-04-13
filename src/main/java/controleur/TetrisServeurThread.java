package controleur;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

import vue.TetrisGUI;
import modele.Grille;
import modele.Jeu;
import modele.Piece;
import modele.PieceFactory;
import modele.TetrisModele;

/**
 * Cette classe servira à écouter les connexions entrantes et à échanger les données entre joueurs
 * */
public class TetrisServeurThread extends Thread{
	
	private ServerSocket serverSocket;
	private Socket socket;
	private TetrisModele tetrisModele;
	private TetrisGUI tetrisGUI;
	private Tetris2PThread tetris2pThread;
	
	public TetrisServeurThread(ServerSocket pServeurSocket, TetrisModele pTetrisModele, TetrisGUI pTetrisGUI, Tetris2PThread pTetris2pThread)
	{
		this.serverSocket = pServeurSocket;
		this.tetrisModele = pTetrisModele;
		this.tetrisGUI = pTetrisGUI;
		this.tetris2pThread = pTetris2pThread;
	}
	
	public void run()
	{
		try {
			while(true)
			{
				this.socket = this.serverSocket.accept(); // Un client se connecte : on l'accepte
				if(!this.tetris2pThread.isAlive())
				{
					this.tetrisModele.getJeu().setJeu2PDemarre(true);
					initialiser_jeu();
					this.tetris2pThread.start();
				}
				InputStreamReader flux = new InputStreamReader(socket.getInputStream());
				BufferedReader entree = new BufferedReader(flux);
				this.tetrisModele.getJeu().setScoreAdversaire(Integer.parseInt(entree.readLine()));
			}
		} catch (Exception e) {
			// TODO: handle exception
			
		}
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
		PieceFactory pf = new PieceFactory();
		Jeu jeu = tetrisModele.getJeu();
		
		jeu.setJeuNonDemarre(false);

		final Timer timerAcceleration = new Timer();
		TimerTask timerTaskAcceleration = new TimerTask()
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
		timerAcceleration.schedule(timerTaskAcceleration, 30000, 30000); // Acceleration toutes les 30
												// secondes
	}
}
