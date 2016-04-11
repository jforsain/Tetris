package controleur;

import modele.Jeu;
import java.util.TimerTask;

public class Accelerer extends TimerTask {

	private Jeu jeu;
	
	public Accelerer (Jeu jeu){
		this.jeu = jeu;
	}

	@Override
	public void run() {
		jeu.set_temps_descente ((int) (jeu.get_temps_descente()*0.9));
		jeu.set_niveau (jeu.get_niveau() + 1);
		
	}
	
}
