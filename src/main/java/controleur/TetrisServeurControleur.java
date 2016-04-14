package controleur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

import modele.TetrisModele;
import vue.TetrisGUI;

public class TetrisServeurControleur {

	private TetrisModele tetrisModele;
	private TetrisGUI tetrisGUI;
	private TetrisServeurThread serveurThread;
	
	public TetrisServeurControleur(TetrisModele pTetrisModele, TetrisGUI pTetrisGUI)
	{
		this.tetrisModele = pTetrisModele;
		this.tetrisGUI = pTetrisGUI;
		enAttenteDeConnexion();
	}
	
	public void enAttenteDeConnexion()
	{
		ServerSocket s = null;
	    Socket conn = null;
	    PrintStream out = null;
	    BufferedReader in = null;
	    String message = null;
	    
		try {
			s = new ServerSocket(13333);
			conn = s.accept(); // En attente (etat bloquant)
			/* La connection est établie */
			
			out = new PrintStream(conn.getOutputStream());
            out.flush();
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            
            
            out.println("Welcome. Server version 1.0");
            out.flush();
           
			this.serveurThread = new TetrisServeurThread(in,out, this.tetrisModele);
			this.serveurThread.start(); // On lance le thread qui va attentre une connexion utilisateur
			
			   connexionOK();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void connexionOK(){

		tetrisGUI.getStatsPanel().layoutModeJeu();
		tetrisGUI.goToGrille();
		ControleurTimer controleurTimer = new ControleurTimer(tetrisModele, tetrisGUI);
		controleurTimer.initialiser_jeu();
	}
}
