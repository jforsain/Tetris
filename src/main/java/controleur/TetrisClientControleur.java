package controleur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import modele.TetrisModele;
import vue.TetrisGUI;

public class TetrisClientControleur {

	private TetrisModele tetrisModele;
	private TetrisGUI tetrisGUI;
	private TetrisClientThread clientThread;
	
	public TetrisClientControleur (TetrisModele pTetrisModele, TetrisGUI pTetrisGUI){
		this.tetrisModele = pTetrisModele;
		this.tetrisGUI = pTetrisGUI;
		connexionLocalHost();
	}
	
	private void connexionLocalHost() {

		PrintWriter s_out = null;
	    BufferedReader s_in = null;
	    Socket s = new Socket();
	    String host = "localhost";
	    
		try {
			s.connect(new InetSocketAddress(host, 13333));
			System.out.println("Connecté");
			connexionOK();
			s_out = new PrintWriter(s.getOutputStream(), true);
			s_in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			
		} catch (UnknownHostException e) {
			System.err.println("Hôte inconnu : " + host);
            System.exit(1);
		} catch (IOException e) {
			System.err.println("Hôte inconnu : " + host);
            System.exit(1);
		}
		this.clientThread = new TetrisClientThread(s_in, s_out, tetrisModele);
		this.clientThread.start();
	}
	
	public void connexionOK(){

		tetrisGUI.getStatsPanel().layoutModeJeu();
		tetrisGUI.goToGrille();
		ControleurTimer controleurTimer = new ControleurTimer(tetrisModele, tetrisGUI);
		controleurTimer.initialiser_jeu();
	}
}
