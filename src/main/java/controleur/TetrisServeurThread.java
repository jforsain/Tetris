package controleur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

import modele.TetrisModele;

/**
 * Cette classe servira à écouter les connexions entrantes et à échanger les
 * données entre joueurs
 * */
public class TetrisServeurThread extends Thread {

	private TetrisModele tetrisModele;
	private BufferedReader bufferedReader;
	private PrintStream printStream;
	private String lecture;
	private PrintWriter printWriter;

	public TetrisServeurThread(BufferedReader pBufferedReader,
		PrintWriter pPrintWrter, TetrisModele pTetrisModele) {
		this.tetrisModele = pTetrisModele;
		this.bufferedReader = pBufferedReader;

		this.printWriter = pPrintWrter;
	}

	public void run() {
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
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
}
