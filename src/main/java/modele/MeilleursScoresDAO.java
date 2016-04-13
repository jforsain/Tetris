package modele;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class MeilleursScoresDAO {

	private int[] meilleursScores;
	private String cheminFichier;
	public MeilleursScoresDAO () {

		meilleursScores = new int[5];
		cheminFichier = "meilleursscores.txt";
		lireFichierScores();
	}
	
	public void lireFichierScores(){

		int i = 0;
		try {
			
			File f = new File(cheminFichier);
			
			Scanner s = new Scanner(f);
			
			for(i=0;i<5;i++)
            {
				meilleursScores[i]=s.nextInt();
            }
			
		}catch (FileNotFoundException exception){
			System.out.println("Le fichier n'a pas été trouvé");
		}
	}	
	
	public void nouveauScore (int score){
		int [] tousScoresTmp = new int [6];
		int scoreMax;
		int scoreTmp;
		
		for (int i = 0; i<5; i++){
			tousScoresTmp[i] = meilleursScores[i];
		}
		tousScoresTmp[5] = score;
		
		for (int i=0; i<6; i++){
			scoreMax = tousScoresTmp[i];
			for (int j=i+1; j<6; j++){
				if (tousScoresTmp [j] > scoreMax){
					scoreTmp = tousScoresTmp[i];
					tousScoresTmp[i] = tousScoresTmp [j];
					tousScoresTmp [j] = scoreTmp;
					scoreMax = tousScoresTmp[i];
				}
				
			}
		}		
		for (int i = 0; i<5; i++){
			meilleursScores[i] = tousScoresTmp[i];
		}
		setMeilleursScores();
	}
	
	
	public void setMeilleursScores() {

		PrintWriter writer;
		try {
			writer = new PrintWriter(cheminFichier, "UTF-8");
			for (int i = 0; i<5; i++){
				writer.println(Integer.toString(meilleursScores[i]));
			}
			writer.close();
		} catch (FileNotFoundException e) {
			System.out.println("Fichier introuvable");
		} catch (UnsupportedEncodingException e) {
			System.out.println(" Erreur d'encodage");
		}
		
	}
	
	public int[] getMeilleursScores (){
		return this.meilleursScores;
	}
	
	
}
