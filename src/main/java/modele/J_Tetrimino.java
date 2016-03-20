package modele;

public class J_Tetrimino extends Piece{
	
	private Couleur couleur;
	private int[][] matricePositionsJTetrimino = {
				{0,0,1,0,0,0,1,0,0,1,1,0,0,0,0,0},
				{0,0,0,0,0,1,1,1,0,0,0,1,0,0,0,0},
				{0,1,1,0,0,1,0,0,0,1,0,0,0,0,0,0},
				{0,0,0,0,0,1,0,0,0,1,1,1,0,0,0,0}
			}; 
		
	public J_Tetrimino() {
		super();
		this.couleur = Couleur.BLEU;
	}

	@Override
	public int[] getiLaPieceTab() {
		return matricePositionsJTetrimino[this.getiPosition()];
	}

}
