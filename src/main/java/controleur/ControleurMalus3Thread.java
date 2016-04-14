package controleur;

import modele.TetrisModele;

public class ControleurMalus3Thread extends Thread{
	
	private TetrisModele tetrisModele;

	public ControleurMalus3Thread (TetrisModele tetrisModele)
	{
		this.tetrisModele = tetrisModele;

	}
	
	@Override
	public void run ()
	{
		for (int i = 0; i<3; i++) { // 3 séquences du malus 3, donc 3 pertes de contrôle successives
			tetrisModele.getJeu().setMalus3EnCours(true);
			try {
				Thread.sleep(3000); // Pendant 3 secondes, l'utilisateur n'a plus le contrôle
			} catch (InterruptedException e) {
				System.out.println("Errer dans le sleep :" + e.getMessage());
			}
			tetrisModele.getJeu().setMalus3EnCours(false);
			try {
				Thread.sleep(1000); // il reprend le contrôle pendant une seconde
			} catch (InterruptedException e) {
				System.out.println("Errer dans le sleep :" + e.getMessage());
			}
		}
	}
}