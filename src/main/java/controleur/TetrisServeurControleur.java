package controleur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
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
	    //PrintStream out = null;
	    BufferedReader in = null;
	    PrintWriter out = null;
	    
		try {
			s = new ServerSocket(13333);
			conn = s.accept(); 
			
			out = new PrintWriter(conn.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            
			this.serveurThread = new TetrisServeurThread(in,out, this.tetrisModele);
			this.serveurThread.start(); 
			
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
