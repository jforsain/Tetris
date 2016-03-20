package modele;

public class I_Tetrimino extends Piece{
	
	private Couleur couleur;
	private int[][] matricePositionsITetrimino = {
				{0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0},
				{1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0},
				{1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0}
			};
	
	public I_Tetrimino() {
		super();
		this.couleur = Couleur.CYAN;
	}

	@Override
	public int[] getiLaPieceTab() {
		return matricePositionsITetrimino[this.getiPosition()];
	}

}
