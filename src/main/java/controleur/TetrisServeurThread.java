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

	public TetrisServeurThread(BufferedReader pBufferedReader,
			PrintStream pPrintStream, TetrisModele pTetrisModele) {
		this.tetrisModele = pTetrisModele;
		this.bufferedReader = pBufferedReader;
		this.printStream = pPrintStream;
	}

	public void run() {
		try {
			while(!this.tetrisModele.getJeu().isGameOver())
			{
				this.printStream.print(this.tetrisModele.getJeu().getScore()); // On envoit notre score au joueur adverse
				this.printStream.flush();
				this.tetrisModele.getJeu().setScoreAdversaire(Integer.parseInt(this.bufferedReader.readLine())); // // On envoit notre score au joueur adverse
			}
			this.printStream.close();
			this.bufferedReader.close();
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
