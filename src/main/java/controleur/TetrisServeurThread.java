package controleur;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import vue.TetrisGUI;
import modele.TetrisModele;

/**
 * Cette classe servira à écouter les connexions entrantes et à échanger les données entre joueurs
 * */
public class TetrisServeurThread extends Thread{
	
	private ServerSocket serverSocket;
	private Socket socket;
	private TetrisModele tetrisModele;
	private TetrisGUI tetrisGUI;
	private Tetris2PStartGameThread tetris2pStartGameThread;
	
	public TetrisServeurThread(ServerSocket pServeurSocket, TetrisModele pTetrisModele, TetrisGUI pTetrisGUI, Tetris2PStartGameThread pTetris2pStartGameThread)
	{
		this.serverSocket = pServeurSocket;
		this.tetrisModele = pTetrisModele;
		this.tetrisGUI = pTetrisGUI;
		this.tetris2pStartGameThread = pTetris2pStartGameThread;
	}
	
	public void run()
	{
		try {
			while(true)
			{
				this.socket = this.serverSocket.accept(); // Un client se connecte : on l'accepte
				if(!this.tetris2pStartGameThread.isAlive())
				{
					this.tetrisModele.getJeu().setJeu2PDemarre(true);
					this.tetrisGUI.removeAll();
					this.tetrisGUI.setContentPane(this.tetrisGUI.getGrille2JoueursPanel());
					this.tetrisGUI.majGUI();
					this.tetris2pStartGameThread.start();
				}
				InputStreamReader flux = new InputStreamReader(socket.getInputStream());
				BufferedReader entree = new BufferedReader(flux);
			}
		} catch (Exception e) {
			// TODO: handle exception
			
		}
	}
}
