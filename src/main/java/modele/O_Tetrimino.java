package modele;

public class O_Tetrimino extends Piece{
	
	private Couleur couleur;
	private int[][] matricePositionsOTetrimino = {
				{0,0,1,0,0,1,1,0,0,1,0,0,0,0,0,0},
				{0,0,0,0,0,1,1,0,0,0,1,1,0,0,0,0},
				{0,0,1,0,0,1,1,0,0,1,0,0,0,0,0,0},
				{0,0,0,0,0,1,1,0,0,0,1,1,0,0,0,0}
			};
	
	public O_Tetrimino() {
		super();
		this.couleur = Couleur.JAUNE;
	}

	@Override

	public int[] getiLaPieceTab() {
		return matricePositionsOTetrimino[this.getiPosition()];
	}

}
