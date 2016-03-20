package modele;

public class Z_Tetrimino extends Piece{
	
	private Couleur couleur;
	private int[][] matricePositionsZTetrimino = {
				{0,1,1,0,0,1,1,0,0,0,0,0,0,0,0,0},
				{0,1,1,0,0,1,1,0,0,0,0,0,0,0,0,0},
				{0,1,1,0,0,1,1,0,0,0,0,0,0,0,0,0},
				{0,1,1,0,0,1,1,0,0,0,0,0,0,0,0,0}
			};
	
	public Z_Tetrimino() {
		super();
		this.couleur = Couleur.VERT;
	}

	@Override
	public int[] getiLaPieceTab() {
		return matricePositionsZTetrimino[this.getiPosition()];
	}

}
