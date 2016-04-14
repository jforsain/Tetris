package controleur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import modele.TetrisModele;

public class TetrisClientThread extends Thread{
	
	private BufferedReader bufferedReader;
	private PrintWriter printWriter;
	private String reponse;
	private TetrisModele tetrisModele;
	
	public TetrisClientThread(BufferedReader pBufferedReader, PrintWriter pPrintWrter, TetrisModele pTetrisModele)
	{
		this.bufferedReader = pBufferedReader;
		this.printWriter = pPrintWrter;
		this.tetrisModele = pTetrisModele;
	}
	
	public void run()
	{
		try {
			while(!this.tetrisModele.getJeu().isGameOver())
			{
				reponse = this.bufferedReader.readLine();
				this.printWriter.print(this.tetrisModele.getJeu().getScore()); // On envoit notre score au joueur adverse
				this.tetrisModele.getJeu().setScoreAdversaire(Integer.parseInt(reponse)); // // On envoit notre score au joueur adverse
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
