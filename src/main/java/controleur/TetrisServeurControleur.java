package controleur;

import java.io.IOException;
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

public class TetrisServeurControleur {

	private int PORT = 13333;
	private TetrisModele tetrisModele;
	private TetrisGUI tetrisGUI;
	
	private TetrisServeurThread serveurThread;
	private Tetris2PThread pTetris2pThread;
	
	public TetrisServeurControleur(TetrisModele pTetrisModele, TetrisGUI pTetrisGUI)
	{
		this.tetrisModele = pTetrisModele;
		this.tetrisGUI = pTetrisGUI;
		enAttenteDeConnexion();
	}
	
	public void enAttenteDeConnexion()
	{
		try {
			ServerSocket serverSocket = new ServerSocket(PORT);
			this.serveurThread = new TetrisServeurThread(serverSocket, this.tetrisModele, this.tetrisGUI, this.pTetris2pThread);
			this.serveurThread.start(); // On lance le thread qui va attentre une connexion utilisateur
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
