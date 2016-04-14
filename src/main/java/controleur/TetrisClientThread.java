package controleur;

import java.io.BufferedReader;
import java.io.IOException;

import modele.TetrisModele;

public class TetrisClientThread extends Thread{
	
	private BufferedReader bufferedReader;
	private String reponse;
	private TetrisModele tetrisModele;
	
	public TetrisClientThread(BufferedReader pBufferedReader, TetrisModele pTetrisModele)
	{
		this.bufferedReader = pBufferedReader;
		this.tetrisModele = pTetrisModele;
	}
	
	public void run()
	{
		try {
			while(( reponse = this.bufferedReader.readLine()) != null)
			{
				this.tetrisModele.getJeu().setScoreAdversaire(Integer.parseInt(reponse));
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
