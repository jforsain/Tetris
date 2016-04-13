package modele;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class MeilleursScoresDAO {

	private Integer[] meilleursScores;
	
	public MeilleursScoresDAO () {
		int i = 0;
		try {
			
			File f = new File(System.getProperty("user.dir") + "\\src\\main\\java\\modele\\meilleursscores.txt");
			 
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr) ;
			
			try { 
				StringBuilder sb = new StringBuilder();
				String line = br.readLine();
				
				while (line != null) {
			        sb.append(line);
			        sb.append(System.lineSeparator());
			        line = br.readLine();
			    }
			    String everything = sb.toString();
			    System.out.println(everything);
			    
			} catch (IOException exception) {
				System.out.println("Erreur lors de la lecture : " + exception.getMessage());
			}
			
		}catch (FileNotFoundException exception){
			System.out.println("Le fichier n'a pas été trouvé");
		}
	
		for (i=0;i<5;i++){
			//System.out.println(meilleursScores[i]);
		}
	}
}
