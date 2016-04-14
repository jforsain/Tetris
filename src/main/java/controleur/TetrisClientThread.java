package controleur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import modele.TetrisModele;

public class TetrisClientThread extends Thread{
	
	private BufferedReader bufferedReader;
	private PrintWriter printWriter;
	private TetrisModele tetrisModele;
	private String lecture;
	
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
				this.printWriter.println(this.tetrisModele.getJeu().getScore()); // On envoie notre score au joueur adverse
				lecture = this.bufferedReader.readLine();
				if (Integer.parseInt(lecture)!= 1){
					this.tetrisModele.getJeu().setScoreAdversaire(Integer.parseInt(lecture)); // On re�oit le score du joueur adverse	
				}
				else
					this.tetrisModele.getJeu().setGameOverAdversaire(true);		
			}

			this.printWriter.println(1); // On notifie l'autre joueur que nous sommes gameover
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
