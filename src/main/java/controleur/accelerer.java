package controleur;

import java.util.TimerTask;

public class accelerer extends TimerTask {

	@Override
	public void run() {
		ControleurTimer.temps_descente = (int) (ControleurTimer.temps_descente*0.9);
	}
	
}
