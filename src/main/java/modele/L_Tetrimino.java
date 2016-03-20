package modele;

public class L_Tetrimino extends Piece{
	
	private Couleur couleur;
	private int[][] matricePositionsLTetrimino = {
				{0,1,0,0,0,1,0,0,0,1,1,0,0,0,0,0},
				{0,0,0,0,0,0,0,1,0,1,1,1,0,0,0,0},
				{0,1,1,0,0,0,1,0,0,0,1,0,0,0,0,0},
				{0,0,0,0,0,1,1,1,0,1,0,0,0,0,0,0}
			};
	
	public L_Tetrimino() {
		super();
		this.couleur = Couleur.ORANGE;
	}

	@Override
	public int[] getiLaPieceTab() {
		return matricePositionsLTetrimino[this.getiPosition()];
	}

}
