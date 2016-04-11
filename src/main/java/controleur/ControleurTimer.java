package controleur;

import java.util.Timer;
import java.util.TimerTask;

import modele.Grille;
import modele.PieceFactory;
import vue.TetrisGUI;
import modele.Piece;
import modele.Jeu;


public class ControleurTimer {
	
	static int temps_descente;
	static int niveau;
	private boolean jeu_en_cours;
	private Timer timer;
	
	public ControleurTimer(){
		temps_descente = 1000;
		jeu_en_cours = true;
		niveau = 1;
	}
	
	
	public void initialiser_jeu(){
		Grille grille = new Grille(20,10);
		PieceFactory pf = new PieceFactory();
		
		Piece piece = pf.getPieceRandom();
		
		grille.apparition_piece(piece);
		
		TetrisGUI affich_tetris = new TetrisGUI(grille);
		
		grille.addObserver(affich_tetris);
		
	    lancer_jeu(grille,piece);
	    
	}
	
	public void lancer_jeu(Grille grille, Piece piece){
		PieceFactory pf = new PieceFactory();
		ControleurClavier clavier = new ControleurClavier(grille, piece);
		Jeu jeu = new Jeu();
		Accelerer accelerer = new Accelerer(jeu); 
		timer = new Timer();
	    timer.schedule(accelerer, 0, 30000);
	    
		while (jeu_en_cours){
			try{
				Thread.sleep(jeu.get_temps_descente());	
			}catch (Exception e){
				e.printStackTrace();
			}
			if (grille.peut_descendre(piece))
				grille.descendre_piece(piece);
			else {
				grille.poser_piece(piece);
				grille.ligne_completee();
				piece = pf.getPieceRandom();
				
				if (grille.peut_apparaitre(piece)){
					grille.apparition_piece(piece);
					clavier.set_piece(piece);	
				}
				
				else {
					System.out.println("GAME OVER");
					jeu_en_cours = false;
				}
			}
		
		}
	}
		

}
