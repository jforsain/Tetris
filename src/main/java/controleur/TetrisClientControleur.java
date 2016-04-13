package controleur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import modele.TetrisModele;
import vue.TetrisGUI;

public class TetrisClientControleur {

	private TetrisModele tetrisModele;
	private TetrisGUI tetrisGUI;
	private String host;
	private int port = 13333;
	
	public TetrisClientControleur (TetrisModele pTetrisModele, TetrisGUI pTetrisGUI){
		this.tetrisModele = pTetrisModele;
		this.tetrisGUI = pTetrisGUI;
		this.host = "localhost";
		connexionLocalHost();
	}
	
	private void connexionLocalHost() {
		// TODO Auto-generated method stub
		try {
			Socket connection = new Socket(host, port);
			
			/* Flux entrant */
			InputStream in = connection.getInputStream();
			InputStreamReader reader = new InputStreamReader(in);
			BufferedReader istream = new BufferedReader(reader);
			
			/* Flux sortant */
			OutputStream out = connection.getOutputStream();
			PrintWriter ostream = new PrintWriter(out);
			ostream.flush();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void connexionOK(){
		ControleurTimer controleurTimer = new ControleurTimer(tetrisModele, tetrisGUI);
		controleurTimer.initialiser_jeu();
	}
}
