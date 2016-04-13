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
					this.tetrisGUI.removeAll();
					this.tetris2pThread.start();
				}
				InputStreamReader flux = new InputStreamReader(socket.getInputStream());
				BufferedReader entree = new BufferedReader(flux);
			}
		} catch (Exception e) {
			// TODO: handle exception
			
		}
	}
}
