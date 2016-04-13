package controleur;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import vue.TetrisGUI;
import modele.TetrisModele;

public class TetrisServeurControleur {

	private int PORT = 13333;
	private Socket socket;
	private TetrisModele tetrisModele;
	private TetrisGUI tetrisGUI;
	
	private TetrisServeurThread serveurThread;
	private Tetris2PStartGameThread t2PStartGameThread;
	public TetrisServeurControleur(TetrisModele pTetrisModele, TetrisGUI pTetrisGUI)
	{
		this.tetrisModele = pTetrisModele;
		this.tetrisGUI = pTetrisGUI;
	}
	
	public void enAttenteDeConnexion()
	{
		try {
			ServerSocket serverSocket = new ServerSocket(PORT);
			this.serveurThread = new TetrisServeurThread(serverSocket, this.tetrisModele, this.tetrisGUI);
			this.serveurThread.start(); // On lance le thread qui va attentre une connexion utilisateur
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
